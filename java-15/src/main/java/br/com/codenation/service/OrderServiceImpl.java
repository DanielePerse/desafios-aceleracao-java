package br.com.codenation.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {
	/**
	 * https://www.devmedia.com.br/java-streams-api-manipulando-colecoes-de-forma-eficiente/37630
	 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/package-summary.html
	 * https://medium.com/@racc.costa/streams-no-java-8-e-no-java-9-36177c5c3313
	 */

	private ProductRepository productRepository = new ProductRepositoryImpl();
	private double DISCOUNT_VALUE = 0.8;

	@Override
	public Double calculateOrderValue(List<OrderItem> items) {		
		List<Product> products = productRepository.findAll();
		
		Double resultSum = 0.0;
		for (int i = 0; i < items.size(); i++) {
			final OrderItem item = items.get(i);
			
			resultSum += products.stream()
				.filter(p -> p.getId() == item.getProductId())
				.map(product -> {
				
				if (product.getIsSale()) {
					return item.getQuantity() * product.getValue() * DISCOUNT_VALUE;
				} else {
					return item.getQuantity() * product.getValue();
				}
			}).findFirst().get();
		}		
		
		return resultSum;
	}

	/**
	 * List e Set. Ambos armazenam uma “lista”. A diferença principal é que o 'Set' não aceita elementos duplicados.
	 * https://medium.com/@racc.costa/collectors-no-java-8-e-no-java-9-6a3ba8f3f42f
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		Set<Product> produtos = new HashSet<Product>();

		produtos = ids
					.stream()
					.map(id -> productRepository.findById(id).get())
					.collect(Collectors.toSet());

		return produtos;
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 * Esse método deverá calcular o valor total de todos os pedidos, sendo que cada pedido corresponde a uma lista de OrderItem. Para calcular o valor
	 * total de cada pedido, você deve seguir as mesmas regras do método calculateOrderValue.
	 * array dentro de outro array
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		List<Product> products = productRepository.findAll();
		
		Double resultSum = 0.0;
		for (int i = 0; i < orders.size(); i++) {
			List<OrderItem> ordersFirstArray = orders.get(i);

			for (int j = 0; j < ordersFirstArray.size(); j++) {
				final OrderItem order = ordersFirstArray.get(j);
				
				resultSum += products.stream()
						.filter(p -> p.getId() == order.getProductId())
						.map(product -> {
							
							if (product.getIsSale()) {
								return order.getQuantity() * product.getValue() * DISCOUNT_VALUE;
							} else {
								return order.getQuantity() * product.getValue();
							}
						}).findFirst().get();
				}
			}
		
		return resultSum;
	}

	/**
	 * Group products using isSale attribute as the map key
	 * Esse método deverá receber uma lista de ids de produtos e retornar um mapa com os produtos agrupados de acordo com o atributo isSale.
	 * usar 2 collects
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {

		return productIds
					.stream()
					.map(id -> productRepository.findById(id).get())
					.collect(Collectors.toList())
					.stream()
					.collect(Collectors.groupingBy(Product::getIsSale));

	}

}