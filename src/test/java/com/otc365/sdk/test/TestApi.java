package com.otc365.sdk.test;

import com.otc365.sdk.ApiV1;
import com.otc365.sdk.ApiV2;
import com.otc365.sdk.util.Utils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestApi {

    @Test
    public void TestV1Api() throws Exception{
        Map<String,Object> params = new HashMap<>();

        params.put("username","haha");
        params.put("areaCode","86");
        params.put("phone","18900000001");
        params.put("idCardType","1");
        params.put("idCardNum","430524143201097878");
        params.put("kyc",2);
        params.put("companyOrderNum","NB"+System.currentTimeMillis());
        params.put("coinSign","USDT");
        params.put("coinAmount",20);
        params.put("total",200);
        params.put("orderPayChannel",3);
        params.put("payCoinSign","cny");
        params.put("companyId","12511234561");
        params.put("orderTime",System.currentTimeMillis());
        params.put("orderType",1);
        params.put("signType",1);
        params.put("syncUrl","https://demo.otc365test.com");
        params.put("asyncUrl","https://demo.otc365test.com");

        ApiV1 apiV1 = new ApiV1("b7ef76e3b52a9d793d98fd6a3d92d6cf");

        String resp = apiV1.call("https://open-v2.otc365test.com/cola/order/addOrder",params);

        System.out.println(resp);
    }


    @Test
    public void TestV2Api() throws Exception{
        Map<String,Object> params = new HashMap<>();

        params.put("username","haha");
        params.put("areaCode","86");
        params.put("phone","18900000001");
        params.put("idCardType","1");
        params.put("idCardNum","430524143201097878");
        params.put("kyc",2);
        params.put("companyOrderNum","NB"+System.currentTimeMillis());
        params.put("coinSign","USDT");
        params.put("coinAmount",20);
        params.put("total",200);
        params.put("orderPayChannel",3);
        params.put("payCoinSign","cny");
        params.put("companyId","12511234561");
        params.put("orderTime",System.currentTimeMillis());
        params.put("orderType",1);
        params.put("syncUrl","https://demo.otc365test.com");
        params.put("asyncUrl","https://demo.otc365test.com");

        ApiV2 apiV2 = new ApiV2("MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIn9F7FILRwSaEhPtI4JzW3Irpi3PPPbgJ/fAa/HMDG/B1E3PL1izd3Ody7foqpqTSr9X2kBOcCSOcxU3JQlkruakE7wRKNHpTlnrBMD9HLgEEItTvyyzGSPHPJ82Ox+DC7h82wS4T5yZJ6ieUxQ7GXlyzI9yQgU2e0aShTPg20JAgMBAAECgYB9ltz5fbeQ1TAUoHa00DcotH40gJH5YM6ws0fVtHUo0bTXNm8R79tvBXt0LhbfA+E4P2OXLoZhvrTcRGB+dbQVtDcJYwl2bHK3ayMF93OzJz75WlXKm0PhF2rIzUW+jHcoQ95YQTXluFI2oJ47DQ28/2sYi9z1eSmXKl2Ug/g0AQJBAMy37/NAIzAEJ/8F/+WOA26FXMeDiKDw3N2GRj/WbsWJd9osZQwpR+MGfXrWzWXl689S7i6f23sAFawzD9R7J9cCQQCsjfGN93sw/2dBQZs+1t7Y4Y3w/dXrVyadfHCq0YwzVf2k3W4rdvjVcfrBo8AbDmZBJcJzME9j4XZiDWkYF/YfAkAec/pA0DiryuJ8QFM5va9rAHG1yC5J6qqgVXobwvVFc1ad4N7DOVzVO8DsxglV8Cbs92QxEVyf5npS3GGtdQiPAkEAldRirIz50R/UPpuC+9uDgPrJTzp5p3HzO8gz5H8zp9fA+Ii1AtS5WE0yGTXgtx2XuHXbFD4ckXPSYW2Xla4orQJBALhuu6sV7TFFFO6hwER0EdCjbTM0FjtIVbZTXPAL+daDsq3FgDLtVQJytv2TEyJiQT6Wj46i+AWAbp47JRXynKw=");

        String resp = apiV2.call("https://open-v2.otc365test.com/cola/apiOpen/addOrder",params);

        System.out.println(resp);
    }
}
