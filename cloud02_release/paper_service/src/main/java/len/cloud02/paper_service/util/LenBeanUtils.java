package len.cloud02.paper_service.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

public class LenBeanUtils {

    public static String[] getNullPropertyNames(Object source) {
        /**
         * 功能：获取所有的属性值为空属性名数组，用于配合copyProperties使用
         */
        BeanWrapper beanWrapper = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds =  beanWrapper.getPropertyDescriptors();
        List<String> Return_nullPropertyNames = new ArrayList<>();
        for (PropertyDescriptor pd : pds) {
            String propertyName = pd.getName();
            if (beanWrapper.getPropertyValue(propertyName) == null) {
                Return_nullPropertyNames.add(propertyName);
            }
        }
        //LenLog.staticInfo("LenBeanUtils.getNullPropertyNames", (String) Return_nullPropertyNames.toArray(new String[Return_nullPropertyNames.size()]));
        return Return_nullPropertyNames.toArray(new String[Return_nullPropertyNames.size()]);
    }

}
