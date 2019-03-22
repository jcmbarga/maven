package org.autodatacorp.orchestration.models.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.autodata.engines.configurator.core.IPwrTeam;
import net.autodata.engines.vocab.core.IccVehicle;
import net.autodata.engines.vocab.core.impl.VocabValue;

/**
 * Created by yaos on 2018-12-07.
 */
public class IccVehicleUtil {
    public static Map<String, Object> getSerializableIccVehicle(IccVehicle iccVehicle) {
        Map<String, Object> tokenData = new HashMap<>();
        Map<String, String> netICCs = new HashMap<>();
        Map<String, String> generalInfo = new HashMap<>();

        // 1) netICC vehicle data
        for (Object k : iccVehicle.getOptionIccValues().keySet()) {
            ArrayList values = (ArrayList) iccVehicle.getOptionIccValues().get(k);
            String netValue = "";
            VocabValue value = null;

            for (int i = 0; i < values.size(); i++) {
                value = (VocabValue) values.get(i);
                for (IPwrTeam pwr : iccVehicle.getPwrTeams()) {
                    //CPP-3748 : Handling null check
                    if(null!=pwr.getOptEngCodes()){
                        for (Object objValue : pwr.getOptEngCodes()) {
                            String engineCode = ((List<String>) objValue).get(0);
    
                            if (iccVehicle.getIccValue(value.getIcCode()).getNetIccValue(Arrays.asList(engineCode)) != null) {
                                netValue = iccVehicle.getIccValue(value.getIcCode()).getNetIccValue(Arrays.asList(engineCode)).toString();
                            }
                        }
                    }
                }
            }
            if(null!=value && null!=value.getIcCode()){
                netICCs.put(value.getIcCode(), netValue);
            }
        }

        // Generic Info
        if(null!=iccVehicle.getGeneralInfo()){
            generalInfo.put("Acode", iccVehicle.getGeneralInfo().getAcode());
            generalInfo.put("CarCode", iccVehicle.getGeneralInfo().getCarCode());
            generalInfo.put("Country_C", iccVehicle.getGeneralInfo().getCountry_C());
            generalInfo.put("Year", iccVehicle.getGeneralInfo().getYear());
            generalInfo.put("Manufac_T", iccVehicle.getGeneralInfo().getManufac_T());
            generalInfo.put("Div_Desc", iccVehicle.getGeneralInfo().getDiv_Desc());
            generalInfo.put("Var_Text", iccVehicle.getGeneralInfo().getVar_Text());
            generalInfo.put("Model_Desc", iccVehicle.getGeneralInfo().getModel_Desc());
            generalInfo.put("Trim_Text", iccVehicle.getGeneralInfo().getTrim_Text());
            generalInfo.put("Doors", iccVehicle.getGeneralInfo().getDoors());
            generalInfo.put("Drive", iccVehicle.getGeneralInfo().getDrive());
            generalInfo.put("Box_Type_T", iccVehicle.getGeneralInfo().getBox_Type_T());
            generalInfo.put("Body_TypeT", iccVehicle.getGeneralInfo().getBody_TypeT());
            generalInfo.put("Body_SizeT", iccVehicle.getGeneralInfo().getBody_SizeT());
            generalInfo.put("RateDutyT", iccVehicle.getGeneralInfo().getRateDutyT());
            generalInfo.put("WheelBase", iccVehicle.getGeneralInfo().getWheelBase());
            generalInfo.put("Effective", iccVehicle.getGeneralInfo().getEffective());
            generalInfo.put("Released", iccVehicle.getGeneralInfo().getReleased());
            generalInfo.put("Dealer", iccVehicle.getGeneralInfo().getDealer());
            generalInfo.put("MSRP", iccVehicle.getGeneralInfo().getMSRP());
            generalInfo.put("Invoice", iccVehicle.getGeneralInfo().getInvoice());
            generalInfo.put("Holdback", iccVehicle.getGeneralInfo().getHoldback());
            generalInfo.put("Freight", iccVehicle.getGeneralInfo().getFreight());
            generalInfo.put("FullBaseMSRP", iccVehicle.getGeneralInfo().getFullBaseMSRP());
            generalInfo.put("FullBaseInv", iccVehicle.getGeneralInfo().getFullBaseInv());
            generalInfo.put("FullBaseDlr", iccVehicle.getGeneralInfo().getFullBaseDlr());
            generalInfo.put("BaseDlrDiscPer", iccVehicle.getGeneralInfo().getBaseDlrDiscPer());
            generalInfo.put("Advert", iccVehicle.getGeneralInfo().getAdvert());
            generalInfo.put("Trim_Desc", iccVehicle.getGeneralInfo().getTrim_Desc());
        }

        tokenData.put("netICCs", netICCs);
        tokenData.put("General Info", generalInfo);

        return tokenData;
    }
}
