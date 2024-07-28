package tekup.tic1n.moyi.models;

import tekup.tic1n.moyi.models.enumeration.PaymentType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class Receipt extends AbstractEntity implements Comparable<Receipt> {
    private LocalDate receiptDate;
    private LocalTime receiptTime;
    private float totalAmount;
    private PaymentType paymentType;
    private List<Stock> medications;

    public Receipt() {}

    public Receipt(int id) {
        super(id);
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    public LocalTime getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(LocalTime receiptTime) {
        this.receiptTime = receiptTime;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public List<Stock> getMedications() {
        return medications;
    }

    public void setMedications(List<Stock> medications) {
        this.medications = medications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Receipt receipt)) return false;
        return id == receipt.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", receiptDate=" + receiptDate +
                ", receiptTime=" + receiptTime +
                ", totalAmount=" + totalAmount +
                ", paymentType=" + paymentType +
                ", medications=" + medications +
                '}';
    }

    @Override
    public int compareTo(Receipt o) {
        return LocalDateTime.of(this.receiptDate,this.receiptTime)
                .compareTo(LocalDateTime.of(o.getReceiptDate(),o.getReceiptTime()));
    }
}
