package com.bluescript.demo.model;
   

 import lombok.Getter;
   import lombok.Setter;                    
   import lombok.Data;
   import lombok.extern.log4j.Log4j2;
   import java.util.*;

   import org.springframework.stereotype.Component;
   
   
@Data
@Component
   
public  class Db2OutIntegers {
private  int  db2BrokeridInt;
private  int  db2PaymentInt;
private  int db2ETermSint;
private  int  db2ESumassuredInt;
private  int  db2EPaddingLen;
private  int db2HBedroomsSint;
private  int  db2HValueInt;
private  int  db2MValueInt;
private  int db2MCcSint;
private  int  db2MPremiumInt;
private  int  db2MAccidentsInt;
private  int db2BFireperilInt;
private  int  db2BFirepremiumInt;
private  int db2BCrimeperilInt;
private  int  db2BCrimepremiumInt;
private  int db2BFloodperilInt;
private  int  db2BFloodpremiumInt;
private  int db2BWeatherperilInt;
private  int  db2BWeatherpremiumInt;
private  int db2BStatusInt;
private  int  db2CPaidInt;
private  int  db2CValueInt;

public String toFixedWidthString(){
return db2BrokeridInt + db2PaymentInt + db2ETermSint + db2ESumassuredInt + db2EPaddingLen + db2HBedroomsSint + db2HValueInt + db2MValueInt + db2MCcSint + db2MPremiumInt + db2MAccidentsInt + db2BFireperilInt + db2BFirepremiumInt + db2BCrimeperilInt + db2BCrimepremiumInt + db2BFloodperilInt + db2BFloodpremiumInt + db2BWeatherperilInt + db2BWeatherpremiumInt + db2BStatusInt + db2CPaidInt + db2CValueInt;
}
   
}