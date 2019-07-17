package it.quake.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Class of user's order
 *
 * @author Christopher Leofreddi
 */
@Entity
@Table(name = "order")
public class Order {

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOrder; //Identifier number of order

    @Column(name = "date_order")
    private Date dateOrder;

    @Column(name = "date_delivery")
    private Date dateDelivery;

    @Column(name = "complete")
    private Boolean complete;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_main_item_ordered", nullable = false)
    private MainItemOrdered mainItemOrdered;

    public Order() {
    }

    public Order(Date dateOrder, Date dateDelivery, Boolean complete, User user, MainItemOrdered mainItemOrdered) {
        this.dateOrder = dateOrder;
        this.dateDelivery = dateDelivery;
        this.complete = complete;
        this.user = user;
        this.mainItemOrdered = mainItemOrdered;
    }

    public Order(@NotNull Integer idOrder, Date dateOrder, Date dateDelivery, Boolean complete, User user, MainItemOrdered mainItemOrdered) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.dateDelivery = dateDelivery;
        this.complete = complete;
        this.user = user;
        this.mainItemOrdered = mainItemOrdered;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public Boolean isComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MainItemOrdered getMainItemOrdered() {
        return mainItemOrdered;
    }

    public void setMainItemOrdered(MainItemOrdered mainItemOrdered) {
        this.mainItemOrdered = mainItemOrdered;
    }
}
