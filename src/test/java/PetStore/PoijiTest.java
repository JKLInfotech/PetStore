package PetStore;

import PetStore.Pojo.PoijiStores;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;

import java.io.File;
import java.util.List;

public class PoijiTest {

    public  static void main(String[] args){

      PoijiOptions options =   PoijiOptions.PoijiOptionsBuilder.settings().addListDelimiter("\n").build();
       List<PoijiStores> poijiStoresListData =  Poiji.fromExcel(new File("src/test/resources/testData/storeData.xlsx"),PoijiStores.class, options);

        System.out.println(poijiStoresListData);

    }
}
