package PetStore.Pojo;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelUnknownCells;

import java.util.List;
import java.util.Map;

public class PoijiStores {

    @ExcelCellName("id")
    private String id;

    @ExcelCellName("petId")
    private String petId;

    @ExcelCellName("quantity")
    private String quantity;

    @ExcelCellName("shipDate")
    private String shipDate ;

    @ExcelCellName("status")
    private String status ;

//    //for more than one status at a time
//    @ExcelCellName("status")
//    private List<String> statusMoreThenOne;

    @ExcelCellName("complete")
    private String complete;

    //for unknow table heading
    @ExcelUnknownCells
    private Map<String,String> extracells;

}
