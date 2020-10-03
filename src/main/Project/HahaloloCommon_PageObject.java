package Project;

public class HahaloloCommon_PageObject {


    public String getGenderNameByValue(String languageSytem, String genderType) {
        if(languageSytem == "vi"){
            if(genderType == "M"){
                return "Nam";
            }else if(genderType =="F"){
                return "Nữ";
            }else if(genderType =="N"){
                return "Khác";
            }else
                return null;
        }
        else if(languageSytem == "en") {
            if (genderType == "M") {
                return "Male";
            } else if (genderType == "F") {
                return "Female";
            } else if (genderType == "N") {
                return "Other";
            } else
                return null;
        }
        return null;
    }
}
