package cn.itcast.mapper;

import java.io.IOException;
import java.util.List;

import cn.itcast.po.OrdersCustom;

public interface OrderMapperCustom {
	
	public List<OrdersCustom> findOrderById() throws IOException;
}
