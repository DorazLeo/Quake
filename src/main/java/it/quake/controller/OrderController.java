package it.quake.controller;

import it.quake.model.Order;
import it.quake.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller to expone services for orders
 *
 * @author Christopher Leofreddi
 */
@RequestMapping("order")
@Controller
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    /**
     * Method for get every object from "order" table
     *
     * @return List of orders
     * @throws Exception
     */
    @RequestMapping(value = "/getAllOrders", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    List<Order> loadOrders() throws Exception {
        return orderRepository.findAll();
    }

    /**
     * Method for save or update the object passed with param.
     * The method is going to run the "SAVE" query if id in the param is null.
     * The method is going to run the "UPDATE" query if id in the param is not null.
     *
     * @param order Order
     * @return Order saved or updated
     * @throws Exception
     */
    @RequestMapping(value = "/saveOrders", method = RequestMethod.POST, produces = {"application/json"})
    public Order saveOrder(@RequestBody Order order) throws Exception {
        return orderRepository.save(order);
    }

    /**
     * Method for delete the object passed with param.
     *
     * @param order Order
     * @throws Exception
     */
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.DELETE, produces = {"application/json"})
    public void deleteOrder(@RequestBody Order order) throws Exception {
        orderRepository.delete(order);
    }

}
