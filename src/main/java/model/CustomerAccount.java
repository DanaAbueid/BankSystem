package model;

public class CustomerAccount {
    private int id;
    private String cifId;
    private String accountNumber;
    private String customerName;
    private int accountTypeId;    // New field for account type ID
    private int accountSubtypeId; // New field for account subtype ID
    private double minimumBalance;
    private String nominee;
    private String relationship;
    private boolean isDeleted;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCifId() {
        return cifId;
    }

    public void setCifId(String cifId) {
        this.cifId = cifId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public int getAccountSubtypeId() {
        return accountSubtypeId;
    }

    public void setAccountSubtypeId(int accountSubtypeId) {
        this.accountSubtypeId = accountSubtypeId;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

	@Override
	public String toString() {
		return "CustomerAccount [id=" + id + ", cifId=" + cifId + ", accountNumber=" + accountNumber + ", customerName="
				+ customerName + ", accountTypeId=" + accountTypeId + ", accountSubtypeId=" + accountSubtypeId
				+ ", minimumBalance=" + minimumBalance + ", nominee=" + nominee + ", relationship=" + relationship
				+ ", isDeleted=" + isDeleted + "]";
	}
    
}

