package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.ModelIdentifier;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the ServiceRates type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "ServiceRates", type = Model.Type.USER, version = 1)
public final class ServiceRates implements Model {
  public static final QueryField ID = field("ServiceRates", "id");
  public static final QueryField SERVICE = field("ServiceRates", "service");
  public static final QueryField RATE = field("ServiceRates", "rate");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String service;
  private final @ModelField(targetType="String", isRequired = true) String rate;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  /** @deprecated This API is internal to Amplify and should not be used. */
  @Deprecated
   public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getService() {
      return service;
  }
  
  public String getRate() {
      return rate;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private ServiceRates(String id, String service, String rate) {
    this.id = id;
    this.service = service;
    this.rate = rate;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ServiceRates serviceRates = (ServiceRates) obj;
      return ObjectsCompat.equals(getId(), serviceRates.getId()) &&
              ObjectsCompat.equals(getService(), serviceRates.getService()) &&
              ObjectsCompat.equals(getRate(), serviceRates.getRate()) &&
              ObjectsCompat.equals(getCreatedAt(), serviceRates.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), serviceRates.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getService())
      .append(getRate())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("ServiceRates {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("service=" + String.valueOf(getService()) + ", ")
      .append("rate=" + String.valueOf(getRate()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static ServiceStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static ServiceRates justId(String id) {
    return new ServiceRates(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      service,
      rate);
  }
  public interface ServiceStep {
    RateStep service(String service);
  }
  

  public interface RateStep {
    BuildStep rate(String rate);
  }
  

  public interface BuildStep {
    ServiceRates build();
    BuildStep id(String id);
  }
  

  public static class Builder implements ServiceStep, RateStep, BuildStep {
    private String id;
    private String service;
    private String rate;
    @Override
     public ServiceRates build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new ServiceRates(
          id,
          service,
          rate);
    }
    
    @Override
     public RateStep service(String service) {
        Objects.requireNonNull(service);
        this.service = service;
        return this;
    }
    
    @Override
     public BuildStep rate(String rate) {
        Objects.requireNonNull(rate);
        this.rate = rate;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String service, String rate) {
      super.id(id);
      super.service(service)
        .rate(rate);
    }
    
    @Override
     public CopyOfBuilder service(String service) {
      return (CopyOfBuilder) super.service(service);
    }
    
    @Override
     public CopyOfBuilder rate(String rate) {
      return (CopyOfBuilder) super.rate(rate);
    }
  }
  

  public static class ServiceRatesIdentifier extends ModelIdentifier<ServiceRates> {
    private static final long serialVersionUID = 1L;
    public ServiceRatesIdentifier(String id) {
      super(id);
    }
  }
  
}
