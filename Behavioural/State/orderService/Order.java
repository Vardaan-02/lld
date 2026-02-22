package Behavioural.State.orderService;

import Behavioural.State.orderService.states.OrderState;
import Behavioural.State.orderService.states.impl.CreatedState;

public class Order {
    private OrderState state;

    public Order() {
        this.state = new CreatedState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void confirmOrder() {
        state.confirmOrder(this);
    }

    public void makePayment() {
        state.makePayment(this);
    }

    public void shipOrder() {
        state.shipOrder(this);
    }

    public void deliverOrder() {
        state.deliverOrder(this);
    }

    public void cancelOrder() {
        state.cancelOrder(this);
    }

    public String getStatus() {
        return state.name();
    }
}
