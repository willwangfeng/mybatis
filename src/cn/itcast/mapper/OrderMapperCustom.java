package cn.itcast.mapper;

import java.io.IOException;
import java.util.List;

import cn.itcast.po.Orders;
import cn.itcast.po.OrdersCustom;

public interface OrderMapperCustom {
	
	public List<OrdersCustom> findOrdersUser() throws IOException;
	
	public List<Orders> findOrdersUserResultMap() throws IOException;
}
