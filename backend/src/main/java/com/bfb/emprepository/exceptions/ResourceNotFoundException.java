package com.bfb.emprepository.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

   public String getResourceName() {
       return resourceName;
   }
   public String getFieldName() {
       return fieldName;
   }
   public Object getFieldValue() {
       return fieldValue;
   }
   public void setResourceName(String resourceName) {
       this.resourceName = resourceName;
   }
   public void setFieldName(String fieldName) {
       this.fieldName = fieldName;
   }
   public void setFieldValue(Object fieldValue) {
       this.fieldValue = fieldValue;
   }
}
