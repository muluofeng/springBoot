package com.xxx.muluofeng.configuration.freemarker;

import freemarker.ext.jsp.TaglibFactory;
import freemarker.template.TemplateModel;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author loocao
 * @since 2015-12-25
 */
public class RichFreeMarkerView extends FreeMarkerView {
    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        super.exposeHelpers(model, request);
        TaglibFactory jspTaglibs = new TaglibFactory(getServletContext());
        List<String> tlds = new ArrayList<String>();
        tlds.add("/tags/spring.tld");
        jspTaglibs.setClasspathTlds(tlds);
        //spring标签
        TemplateModel spring = jspTaglibs.get("http://www.springframework.org/tags");
        model.put("spring", spring);
        //form标签
//        TemplateModel form = jspTaglibs.get("/resources/tags/spring-form.tld");
//        model.put("form", form);
        //security标签
//        TemplateModel security = jspTaglibs.get("/WEB-INF/tag/security.tld");
//        model.put("sec", security);
    }
}
