package PetStore.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Builder()
@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoStores {

    private String id = "10";
    private String petId = "20";
    private String quantity = "30";
    private String shipDate = "2023-11-21T09:51:58.683Z";
    private String status = "Available";
    private String complete = "true";

}
