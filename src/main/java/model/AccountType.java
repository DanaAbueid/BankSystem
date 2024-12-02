package model;

public class AccountType {
    private int typeId;
    private String typeName;
    private int subTypeId;
    private String subTypeName;

    // Getters and Setters
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(int subTypeId) {
        this.subTypeId = subTypeId;
    }

    public String getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }

	@Override
	public String toString() {
		return "AccountType [typeId=" + typeId + ", typeName=" + typeName + ", subTypeId=" + subTypeId
				+ ", subTypeName=" + subTypeName + "]";
	}
    
}
