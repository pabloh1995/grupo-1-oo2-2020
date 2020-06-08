package com.unla.Grupo8OO22020.services.implementation;

import java.util.ArrayList;


import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo8OO22020.converters.PedidoConverter;
import com.unla.Grupo8OO22020.entities.Batch;
import com.unla.Grupo8OO22020.entities.Employee;
import com.unla.Grupo8OO22020.entities.Pedido;
import com.unla.Grupo8OO22020.models.BatchModel;
import com.unla.Grupo8OO22020.models.EmployeeModel;
import com.unla.Grupo8OO22020.models.PedidoModel;
import com.unla.Grupo8OO22020.models.RankingProductModel;
import com.unla.Grupo8OO22020.repositories.IPedidoRepository;
import com.unla.Grupo8OO22020.services.IBatchService;
import com.unla.Grupo8OO22020.services.IEmployeeService;
import com.unla.Grupo8OO22020.services.IPedidoService;
import com.unla.Grupo8OO22020.services.IProductService;
import com.unla.Grupo8OO22020.services.IStoreService;


@Service("pedidoService")
public class PedidoService implements IPedidoService{
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	
	@Autowired
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	
	@Autowired
	@Qualifier("batchService")
	private IBatchService batchService;
	

	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;
	
	@Override
	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}	
	
	@Override
	public void setAttributes(PedidoModel pedidoModel) {
		pedidoModel.setEmployee(employeeService.findById(pedidoModel.getEmployee().getId()));
		pedidoModel.setCollaborator(employeeService.findById(pedidoModel.getEmployee().getId()));
		pedidoModel.setStore(storeService.findByIdStore(employeeService.findById(pedidoModel.getEmployee().getId()).getStore().getIdStore()));
		pedidoModel.setSubtotal(productService.findByIdProduct(pedidoModel.getProduct().getIdProduct()).getPrice()*pedidoModel.getQuantity());
		
	}
	
	@Override
	public PedidoModel insert(PedidoModel pedidoModel) {
		Pedido pedido=pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModel(pedido);
	}
	
	@Override
	public PedidoModel update(PedidoModel pedidoModel) {
		this.setAttributes(pedidoModel);
	    Pedido pedido=pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModel(pedido);
	}
	
	@Override
	public PedidoModel findByIdPedido(long idPedido) {
		return pedidoConverter.entityToModel(pedidoRepository.findByIdPedido(idPedido));
	}
	
	
	
	@Override
	public List<PedidoModel> getAlls() {
		List<PedidoModel> models = new ArrayList<PedidoModel>();
		for (Pedido pedido : pedidoRepository.findAll()) {
			models.add(pedidoConverter.entityToModel(pedido));
		}
		return models;
	}
	
	@Override
	public List<Batch> getActiveBatches(PedidoModel pedidoModel) {
		List<Batch> activeBatches = new ArrayList<Batch>();
		System.out.println(pedidoModel.getStore().getAddress());
			for (Batch b : batchService.getAll()) {
				if (b.getProduct().getIdProduct() == pedidoModel.getProduct().getIdProduct() && b.getStore().getIdStore() ==pedidoModel.getStore().getIdStore() && b.isActive()) {
					activeBatches.add(b);
				}
			}
			return activeBatches;
		}

	@Override
	public int calculateStock(PedidoModel pedidoModel) {
		int total = 0;
			for (Batch b : getActiveBatches(pedidoModel)) {
				total += b.getQuantities();
			}
			return total;
		}
		
    @Override
	public boolean validarConsumo(PedidoModel pedidoModel) {
		return (calculateStock(pedidoModel) >= pedidoModel.getQuantity()) ? true : false; 
		}
		
	@Override
	public void consumoStock(PedidoModel pedidoModel) {
	     int quantity = pedidoModel.getQuantity();
		 int index = 0;
			while (index < getActiveBatches(pedidoModel).size() && quantity > 0) {
				Batch b = getActiveBatches(pedidoModel).get(index);
				if (b.getQuantities() > quantity) {
					b.setQuantities(b.getQuantities() - quantity);
					quantity = 0;
				} else if (b.getQuantities() < quantity) {
					quantity -= b.getQuantities();
					b.setQuantities(0);	
					b.setActive(false);
				} else if (b.getQuantities() == quantity) {
					quantity = 0;
					b.setQuantities(0);
					b.setActive(false);
				}
				BatchModel bM = batchService.findByIdBatch(b.getIdBatch());
				bM.setQuantities(b.getQuantities());
				bM.setActive(b.isActive());
				batchService.insert(bM);
				index++;
			}
			this.paySalary(pedidoModel);
		}
	
	
	
	public void paySalary(PedidoModel pedidoModel) {
		System.out.println(pedidoModel.getCollaborator().getDni()+"    "+pedidoModel.getEmployee().getDni());
		EmployeeModel employee=pedidoModel.getEmployee();
		EmployeeModel collaborator=pedidoModel.getCollaborator();
		if(employee.getDni()==collaborator.getDni()) {
		employee.setCommission(pedidoModel.getEmployee().getCommission()+pedidoModel.getSubtotal()*0.05);
		}
		else
		{
			employee.setCommission(pedidoModel.getEmployee().getCommission()+pedidoModel.getSubtotal()*0.03);
			collaborator.setCommission(pedidoModel.getCollaborator().getCommission()+pedidoModel.getSubtotal()*0.02);
			employeeService.insertOrUpdate(pedidoModel.getCollaborator());
		}
		employeeService.insertOrUpdate(pedidoModel.getEmployee());
		
	}
	
	
	
	@Override
	public List<RankingProductModel> rankingProduct(List<Pedido> pedidos){
		Map<String,Integer> ranking = new HashMap<String,Integer>();
		List<RankingProductModel> rankingProd = new ArrayList<RankingProductModel>();
		for(Pedido p: pedidos) {
			if(p.isAccept()) {
				if(!ranking.containsKey(p.getProduct().getDescription())) {
					ranking.put(p.getProduct().getDescription(), p.getQuantity());
				}
				else {
					ranking.replace(p.getProduct().getDescription(), ranking.get(p.getProduct().getDescription())+p.getQuantity());
				}
			}
		}
		for(String key : ranking.keySet()) {
			rankingProd.add(new RankingProductModel(key, ranking.get(key)));
		}
		Collections.sort(rankingProd, Collections.reverseOrder(Comparator.comparing(RankingProductModel::getQuantitySold)));
		return rankingProd;
	}	
	
	@Override
	public boolean remove(long idPedido) {
		try {
			pedidoRepository.deleteById(idPedido);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

 }
