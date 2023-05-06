package org.example.repository;

import org.example.dao.OrderDao;
import org.example.dto.CarDto;
import org.example.dto.OrderDto;
import org.example.entity.Car;
import org.example.entity.Order;
import org.example.mappers.OrderMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class OrderRepository implements org.example.repository.interfaces.OrderRepository {
    private OrderDao orderDao;
    private OrderMapper orderMapper;

    public OrderRepository(OrderDao orderDao, OrderMapper orderMapper) {
        this.orderDao = orderDao;
        this.orderMapper = orderMapper;
    }

    public OrderDto getById(Long id){
        var order = orderDao.findById(id);
        if (order.isPresent()){
            return orderMapper.toDto(order.get());
        }

        return new OrderDto();
    }

    public List<OrderDto> getAll()
    {
        var orders = orderDao.findAll();

        var ordersDto = new ArrayList<OrderDto>();

        for (var order :
                orders) {
            ordersDto.add(orderMapper.toDto(order));
        }

        return ordersDto;
    }

    public OrderDto createOrder(OrderDto orderDto)
    {
        var startDate = new Date();

        var orderEntity = orderMapper.toEntity(orderDto);

        orderDao.save(orderEntity);
        
        return orderMapper.toDto(orderEntity);
    }
}