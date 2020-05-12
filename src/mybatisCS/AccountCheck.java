package mybatisCS;

public class AccountCheck {
    private String billDate;
    private String busiId;
    private String orderType;

    @Override
    public String toString() {
        return "AccountCheck{" +
                "billDate='" + billDate + '\'' +
                ", busiId='" + busiId + '\'' +
                ", orderType='" + orderType + '\'' +
                '}';
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
