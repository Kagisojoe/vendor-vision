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

/** This is an auto generated class representing the Vendor type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Vendors", type = Model.Type.USER, version = 1)
public final class Vendor implements Model {
  public static final QueryField ID = field("Vendor", "id");
  public static final QueryField FIRST_NAME = field("Vendor", "firstName");
  public static final QueryField LAST_NAME = field("Vendor", "lastName");
  public static final QueryField EMAIL = field("Vendor", "email");
  public static final QueryField PASSWORD = field("Vendor", "password");
  public static final QueryField COMPANY_NAME = field("Vendor", "companyName");
  public static final QueryField COMPANY_EMAIL = field("Vendor", "companyEmail");
  public static final QueryField COMPANY_ADDRESS = field("Vendor", "companyAddress");
  public static final QueryField COMPANY_NUMBER = field("Vendor", "companyNumber");
  public static final QueryField COMPANY_COUNTRY = field("Vendor", "companyCountry");
  public static final QueryField COMPANY_CITY = field("Vendor", "companyCity");
  public static final QueryField POSTAL_CODE = field("Vendor", "postalCode");
  public static final QueryField BEEE_CERTIFICATE = field("Vendor", "beeeCertificate");
  public static final QueryField TAX_CERTIFICATE = field("Vendor", "taxCertificate");
  public static final QueryField CIPC_CERTIFICATE = field("Vendor", "cipcCertificate");
  public static final QueryField OTHER_CERTIFICATE = field("Vendor", "otherCertificate");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String firstName;
  private final @ModelField(targetType="String", isRequired = true) String lastName;
  private final @ModelField(targetType="String", isRequired = true) String email;
  private final @ModelField(targetType="String", isRequired = true) String password;
  private final @ModelField(targetType="String", isRequired = true) String companyName;
  private final @ModelField(targetType="String", isRequired = true) String companyEmail;
  private final @ModelField(targetType="String", isRequired = true) String companyAddress;
  private final @ModelField(targetType="String", isRequired = true) String companyNumber;
  private final @ModelField(targetType="String", isRequired = true) String companyCountry;
  private final @ModelField(targetType="String", isRequired = true) String companyCity;
  private final @ModelField(targetType="String", isRequired = true) String postalCode;
  private final @ModelField(targetType="String", isRequired = true) String beeeCertificate;
  private final @ModelField(targetType="String", isRequired = true) String taxCertificate;
  private final @ModelField(targetType="String", isRequired = true) String cipcCertificate;
  private final @ModelField(targetType="String", isRequired = true) String otherCertificate;
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
  
  public String getFirstName() {
      return firstName;
  }
  
  public String getLastName() {
      return lastName;
  }
  
  public String getEmail() {
      return email;
  }
  
  public String getPassword() {
      return password;
  }
  
  public String getCompanyName() {
      return companyName;
  }
  
  public String getCompanyEmail() {
      return companyEmail;
  }
  
  public String getCompanyAddress() {
      return companyAddress;
  }
  
  public String getCompanyNumber() {
      return companyNumber;
  }
  
  public String getCompanyCountry() {
      return companyCountry;
  }
  
  public String getCompanyCity() {
      return companyCity;
  }
  
  public String getPostalCode() {
      return postalCode;
  }
  
  public String getBeeeCertificate() {
      return beeeCertificate;
  }
  
  public String getTaxCertificate() {
      return taxCertificate;
  }
  
  public String getCipcCertificate() {
      return cipcCertificate;
  }
  
  public String getOtherCertificate() {
      return otherCertificate;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Vendor(String id, String firstName, String lastName, String email, String password, String companyName, String companyEmail, String companyAddress, String companyNumber, String companyCountry, String companyCity, String postalCode, String beeeCertificate, String taxCertificate, String cipcCertificate, String otherCertificate) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.companyName = companyName;
    this.companyEmail = companyEmail;
    this.companyAddress = companyAddress;
    this.companyNumber = companyNumber;
    this.companyCountry = companyCountry;
    this.companyCity = companyCity;
    this.postalCode = postalCode;
    this.beeeCertificate = beeeCertificate;
    this.taxCertificate = taxCertificate;
    this.cipcCertificate = cipcCertificate;
    this.otherCertificate = otherCertificate;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Vendor vendor = (Vendor) obj;
      return ObjectsCompat.equals(getId(), vendor.getId()) &&
              ObjectsCompat.equals(getFirstName(), vendor.getFirstName()) &&
              ObjectsCompat.equals(getLastName(), vendor.getLastName()) &&
              ObjectsCompat.equals(getEmail(), vendor.getEmail()) &&
              ObjectsCompat.equals(getPassword(), vendor.getPassword()) &&
              ObjectsCompat.equals(getCompanyName(), vendor.getCompanyName()) &&
              ObjectsCompat.equals(getCompanyEmail(), vendor.getCompanyEmail()) &&
              ObjectsCompat.equals(getCompanyAddress(), vendor.getCompanyAddress()) &&
              ObjectsCompat.equals(getCompanyNumber(), vendor.getCompanyNumber()) &&
              ObjectsCompat.equals(getCompanyCountry(), vendor.getCompanyCountry()) &&
              ObjectsCompat.equals(getCompanyCity(), vendor.getCompanyCity()) &&
              ObjectsCompat.equals(getPostalCode(), vendor.getPostalCode()) &&
              ObjectsCompat.equals(getBeeeCertificate(), vendor.getBeeeCertificate()) &&
              ObjectsCompat.equals(getTaxCertificate(), vendor.getTaxCertificate()) &&
              ObjectsCompat.equals(getCipcCertificate(), vendor.getCipcCertificate()) &&
              ObjectsCompat.equals(getOtherCertificate(), vendor.getOtherCertificate()) &&
              ObjectsCompat.equals(getCreatedAt(), vendor.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), vendor.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getFirstName())
      .append(getLastName())
      .append(getEmail())
      .append(getPassword())
      .append(getCompanyName())
      .append(getCompanyEmail())
      .append(getCompanyAddress())
      .append(getCompanyNumber())
      .append(getCompanyCountry())
      .append(getCompanyCity())
      .append(getPostalCode())
      .append(getBeeeCertificate())
      .append(getTaxCertificate())
      .append(getCipcCertificate())
      .append(getOtherCertificate())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Vendor {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("firstName=" + String.valueOf(getFirstName()) + ", ")
      .append("lastName=" + String.valueOf(getLastName()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("password=" + String.valueOf(getPassword()) + ", ")
      .append("companyName=" + String.valueOf(getCompanyName()) + ", ")
      .append("companyEmail=" + String.valueOf(getCompanyEmail()) + ", ")
      .append("companyAddress=" + String.valueOf(getCompanyAddress()) + ", ")
      .append("companyNumber=" + String.valueOf(getCompanyNumber()) + ", ")
      .append("companyCountry=" + String.valueOf(getCompanyCountry()) + ", ")
      .append("companyCity=" + String.valueOf(getCompanyCity()) + ", ")
      .append("postalCode=" + String.valueOf(getPostalCode()) + ", ")
      .append("beeeCertificate=" + String.valueOf(getBeeeCertificate()) + ", ")
      .append("taxCertificate=" + String.valueOf(getTaxCertificate()) + ", ")
      .append("cipcCertificate=" + String.valueOf(getCipcCertificate()) + ", ")
      .append("otherCertificate=" + String.valueOf(getOtherCertificate()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static FirstNameStep builder() {
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
  public static Vendor justId(String id) {
    return new Vendor(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      firstName,
      lastName,
      email,
      password,
      companyName,
      companyEmail,
      companyAddress,
      companyNumber,
      companyCountry,
      companyCity,
      postalCode,
      beeeCertificate,
      taxCertificate,
      cipcCertificate,
      otherCertificate);
  }
  public interface FirstNameStep {
    LastNameStep firstName(String firstName);
  }
  

  public interface LastNameStep {
    EmailStep lastName(String lastName);
  }
  

  public interface EmailStep {
    PasswordStep email(String email);
  }
  

  public interface PasswordStep {
    CompanyNameStep password(String password);
  }
  

  public interface CompanyNameStep {
    CompanyEmailStep companyName(String companyName);
  }
  

  public interface CompanyEmailStep {
    CompanyAddressStep companyEmail(String companyEmail);
  }
  

  public interface CompanyAddressStep {
    CompanyNumberStep companyAddress(String companyAddress);
  }
  

  public interface CompanyNumberStep {
    CompanyCountryStep companyNumber(String companyNumber);
  }
  

  public interface CompanyCountryStep {
    CompanyCityStep companyCountry(String companyCountry);
  }
  

  public interface CompanyCityStep {
    PostalCodeStep companyCity(String companyCity);
  }
  

  public interface PostalCodeStep {
    BeeeCertificateStep postalCode(String postalCode);
  }
  

  public interface BeeeCertificateStep {
    TaxCertificateStep beeeCertificate(String beeeCertificate);
  }
  

  public interface TaxCertificateStep {
    CipcCertificateStep taxCertificate(String taxCertificate);
  }
  

  public interface CipcCertificateStep {
    OtherCertificateStep cipcCertificate(String cipcCertificate);
  }
  

  public interface OtherCertificateStep {
    BuildStep otherCertificate(String otherCertificate);
  }
  

  public interface BuildStep {
    Vendor build();
    BuildStep id(String id);
  }
  

  public static class Builder implements FirstNameStep, LastNameStep, EmailStep, PasswordStep, CompanyNameStep, CompanyEmailStep, CompanyAddressStep, CompanyNumberStep, CompanyCountryStep, CompanyCityStep, PostalCodeStep, BeeeCertificateStep, TaxCertificateStep, CipcCertificateStep, OtherCertificateStep, BuildStep {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String companyName;
    private String companyEmail;
    private String companyAddress;
    private String companyNumber;
    private String companyCountry;
    private String companyCity;
    private String postalCode;
    private String beeeCertificate;
    private String taxCertificate;
    private String cipcCertificate;
    private String otherCertificate;
    @Override
     public Vendor build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Vendor(
          id,
          firstName,
          lastName,
          email,
          password,
          companyName,
          companyEmail,
          companyAddress,
          companyNumber,
          companyCountry,
          companyCity,
          postalCode,
          beeeCertificate,
          taxCertificate,
          cipcCertificate,
          otherCertificate);
    }
    
    @Override
     public LastNameStep firstName(String firstName) {
        Objects.requireNonNull(firstName);
        this.firstName = firstName;
        return this;
    }
    
    @Override
     public EmailStep lastName(String lastName) {
        Objects.requireNonNull(lastName);
        this.lastName = lastName;
        return this;
    }
    
    @Override
     public PasswordStep email(String email) {
        Objects.requireNonNull(email);
        this.email = email;
        return this;
    }
    
    @Override
     public CompanyNameStep password(String password) {
        Objects.requireNonNull(password);
        this.password = password;
        return this;
    }
    
    @Override
     public CompanyEmailStep companyName(String companyName) {
        Objects.requireNonNull(companyName);
        this.companyName = companyName;
        return this;
    }
    
    @Override
     public CompanyAddressStep companyEmail(String companyEmail) {
        Objects.requireNonNull(companyEmail);
        this.companyEmail = companyEmail;
        return this;
    }
    
    @Override
     public CompanyNumberStep companyAddress(String companyAddress) {
        Objects.requireNonNull(companyAddress);
        this.companyAddress = companyAddress;
        return this;
    }
    
    @Override
     public CompanyCountryStep companyNumber(String companyNumber) {
        Objects.requireNonNull(companyNumber);
        this.companyNumber = companyNumber;
        return this;
    }
    
    @Override
     public CompanyCityStep companyCountry(String companyCountry) {
        Objects.requireNonNull(companyCountry);
        this.companyCountry = companyCountry;
        return this;
    }
    
    @Override
     public PostalCodeStep companyCity(String companyCity) {
        Objects.requireNonNull(companyCity);
        this.companyCity = companyCity;
        return this;
    }
    
    @Override
     public BeeeCertificateStep postalCode(String postalCode) {
        Objects.requireNonNull(postalCode);
        this.postalCode = postalCode;
        return this;
    }
    
    @Override
     public TaxCertificateStep beeeCertificate(String beeeCertificate) {
        Objects.requireNonNull(beeeCertificate);
        this.beeeCertificate = beeeCertificate;
        return this;
    }
    
    @Override
     public CipcCertificateStep taxCertificate(String taxCertificate) {
        Objects.requireNonNull(taxCertificate);
        this.taxCertificate = taxCertificate;
        return this;
    }
    
    @Override
     public OtherCertificateStep cipcCertificate(String cipcCertificate) {
        Objects.requireNonNull(cipcCertificate);
        this.cipcCertificate = cipcCertificate;
        return this;
    }
    
    @Override
     public BuildStep otherCertificate(String otherCertificate) {
        Objects.requireNonNull(otherCertificate);
        this.otherCertificate = otherCertificate;
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
    private CopyOfBuilder(String id, String firstName, String lastName, String email, String password, String companyName, String companyEmail, String companyAddress, String companyNumber, String companyCountry, String companyCity, String postalCode, String beeeCertificate, String taxCertificate, String cipcCertificate, String otherCertificate) {
      super.id(id);
      super.firstName(firstName)
        .lastName(lastName)
        .email(email)
        .password(password)
        .companyName(companyName)
        .companyEmail(companyEmail)
        .companyAddress(companyAddress)
        .companyNumber(companyNumber)
        .companyCountry(companyCountry)
        .companyCity(companyCity)
        .postalCode(postalCode)
        .beeeCertificate(beeeCertificate)
        .taxCertificate(taxCertificate)
        .cipcCertificate(cipcCertificate)
        .otherCertificate(otherCertificate);
    }
    
    @Override
     public CopyOfBuilder firstName(String firstName) {
      return (CopyOfBuilder) super.firstName(firstName);
    }
    
    @Override
     public CopyOfBuilder lastName(String lastName) {
      return (CopyOfBuilder) super.lastName(lastName);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder password(String password) {
      return (CopyOfBuilder) super.password(password);
    }
    
    @Override
     public CopyOfBuilder companyName(String companyName) {
      return (CopyOfBuilder) super.companyName(companyName);
    }
    
    @Override
     public CopyOfBuilder companyEmail(String companyEmail) {
      return (CopyOfBuilder) super.companyEmail(companyEmail);
    }
    
    @Override
     public CopyOfBuilder companyAddress(String companyAddress) {
      return (CopyOfBuilder) super.companyAddress(companyAddress);
    }
    
    @Override
     public CopyOfBuilder companyNumber(String companyNumber) {
      return (CopyOfBuilder) super.companyNumber(companyNumber);
    }
    
    @Override
     public CopyOfBuilder companyCountry(String companyCountry) {
      return (CopyOfBuilder) super.companyCountry(companyCountry);
    }
    
    @Override
     public CopyOfBuilder companyCity(String companyCity) {
      return (CopyOfBuilder) super.companyCity(companyCity);
    }
    
    @Override
     public CopyOfBuilder postalCode(String postalCode) {
      return (CopyOfBuilder) super.postalCode(postalCode);
    }
    
    @Override
     public CopyOfBuilder beeeCertificate(String beeeCertificate) {
      return (CopyOfBuilder) super.beeeCertificate(beeeCertificate);
    }
    
    @Override
     public CopyOfBuilder taxCertificate(String taxCertificate) {
      return (CopyOfBuilder) super.taxCertificate(taxCertificate);
    }
    
    @Override
     public CopyOfBuilder cipcCertificate(String cipcCertificate) {
      return (CopyOfBuilder) super.cipcCertificate(cipcCertificate);
    }
    
    @Override
     public CopyOfBuilder otherCertificate(String otherCertificate) {
      return (CopyOfBuilder) super.otherCertificate(otherCertificate);
    }
  }
  

  public static class VendorIdentifier extends ModelIdentifier<Vendor> {
    private static final long serialVersionUID = 1L;
    public VendorIdentifier(String id) {
      super(id);
    }
  }
  
}
