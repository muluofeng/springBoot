<#ftl strip_whitespace=true>
<#--
 * spring.ftl
 *
 * This file consists of a collection of FreeMarker macros aimed at easing
 * some of the common requirements of controller applications - in particular
 * handling of forms.
 *
 * Spring's FreeMarker support will automatically make this file and therefore
 * all macros within it available to any application using Spring's
 * FreeMarkerConfigurer.
 *
 * To take advantage of these macros, the "exposeSpringMacroHelpers" property
 * of the FreeMarker class needs to be set to "true". This will expose a
 * RequestContext under the name "springMacroRequestContext", as needed by
 * the macros in this library.
 *
 * @author Darren Davison
 * @author Juergen Hoeller
 * @since 1.1
 -->

<#--
 * message
 *
 * Macro to translate a message code into a message.
 -->
<#macro message code>${springMacroRequestContext.getMessage(code)}</#macro>

<#--
 * messageText
 *
 * Macro to translate a message code into a message,
 * using the given default text if no message found.
 -->
<#macro messageText code, text>${springMacroRequestContext.getMessage(code, text)}</#macro>

<#--
 * messageArgs
 *
 * Macro to translate a message code with arguments into a message.
 -->
<#macro messageArgs code, args>${springMacroRequestContext.getMessage(code, args)}</#macro>

<#--
 * messageArgsText
 *
 * Macro to translate a message code with arguments into a message,
 * using the given default text if no message found.
 -->
<#macro messageArgsText code, args, text>${springMacroRequestContext.getMessage(code, args, text)}</#macro>

<#--
 * theme
 *
 * Macro to translate a theme message code into a message.
 -->
<#macro theme code>${springMacroRequestContext.getThemeMessage(code)}</#macro>

<#--
 * themeText
 *
 * Macro to translate a theme message code into a message,
 * using the given default text if no message found.
 -->
<#macro themeText code, text>${springMacroRequestContext.getThemeMessage(code, text)}</#macro>

<#--
 * themeArgs
 *
 * Macro to translate a theme message code with arguments into a message.
 -->
<#macro themeArgs code, args>${springMacroRequestContext.getThemeMessage(code, args)}</#macro>

<#--
 * themeArgsText
 *
 * Macro to translate a theme message code with arguments into a message,
 * using the given default text if no message found.
 -->
<#macro themeArgsText code, args, text>${springMacroRequestContext.getThemeMessage(code, args, text)}</#macro>

<#--
 * url
 *
 * Takes a relative URL and makes it absolute from the server root by
 * adding the context root for the controller application.
 -->
<#macro url relativeUrl extra...><#if extra?? && extra?size!=0>${springMacroRequestContext.getContextUrl(relativeUrl,extra)}<#else>${springMacroRequestContext.getContextUrl(relativeUrl)}</#if></#macro>

<#--
 * bind
 *
 * Exposes a BindStatus object for the given bind path, which can be
 * a bean (e.g. "person") to get global errors, or a bean property
 * (e.g. "person.name") to get field errors. Can be called multiple times
 * within a form to bind to multiple command objects and/or field names.
 *
 * This macro will participate in the default HTML escape setting for the given
 * RequestContext. This can be customized by calling "setDefaultHtmlEscape"
 * on the "springMacroRequestContext" context variable, or via the
 * "defaultHtmlEscape" context-param in controller.xml (same as for the JSP bind tag).
 * Also regards a "htmlEscape" variable in the namespace of this library.
 *
 * Producing no output, the following context variable will be available
 * each time this macro is referenced (assuming you import this library in
 * your templates with the namespace 'spring'):
 *
 *   spring.status : a BindStatus instance holding the command object name,
 *   expression, value, and error messages and codes for the path supplied
 *
 * @param path : the path (string value) of the value required to bind to.
 *   Spring defaults to a command name of "command" but this can be overridden
 *   by user config.
 -->
<#macro bind path>
    <#if htmlEscape?exists>
        <#assign status = springMacroRequestContext.getBindStatus(path, htmlEscape)>
    <#else>
        <#assign status = springMacroRequestContext.getBindStatus(path)>
    </#if>
<#-- assign a temporary value, forcing a string representation for any
kind of variable. This temp value is only used in this macro lib -->
    <#if status.value?exists && status.value?is_boolean>
        <#assign stringStatusValue=status.value?string>
    <#else>
        <#assign stringStatusValue=status.value?default("")>
    </#if>
</#macro>

<#--
 * bindEscaped
 *
 * Similar to spring:bind, but takes an explicit HTML escape flag rather
 * than relying on the default HTML escape setting.
 -->
<#macro bindEscaped path, htmlEscape>
    <#assign status = springMacroRequestContext.getBindStatus(path, htmlEscape)>
<#-- assign a temporary value, forcing a string representation for any
kind of variable. This temp value is only used in this macro lib -->
    <#if status.value?exists && status.value?is_boolean>
        <#assign stringStatusValue=status.value?string>
    <#else>
        <#assign stringStatusValue=status.value?default("")>
    </#if>
</#macro>

<#--
 * formInput
 *
 * Display a form input field of type 'text' and bind it to an attribute
 * of a command or bean.
 *
 * @param path the name of the field to bind to
 * @param attributes any additional attributes for the element (such as class
 *    or CSS styles or size
 -->
<#macro formInput path attributes="" fieldType="text">
    <@bind path/>
<input type="${fieldType}" id="${status.expression?replace('[','')?replace(']','')}" name="${status.expression}" value="<#if fieldType!="password">${stringStatusValue}</#if>" ${attributes}<@closeTag/>
</#macro>

<#--
 * formInput
 *
 * Display a form input field of type 'text' and bind it to an attribute
 * of a command or bean.
 *
 * @param path the name of the field to bind to
 * @param attributes any additional attributes for the element (such as class
 *    or CSS styles or size
 -->
<#macro formCaptcha path attributes="" fieldType="text">
    <@bind path/>
<input type="${fieldType}" id="${status.expression?replace('[','')?replace(']','')}" name="${status.expression}" value="" ${attributes}<@closeTag/>
</#macro>

<#--
 * formPasswordInput
 *
 * Display a form input field of type 'password' and bind it to an attribute
 * of a command or bean. No value will ever be displayed. This functionality
 * can also be obtained by calling the formInput macro with a 'type' parameter
 * of 'password'.
 *
 * @param path the name of the field to bind to
 * @param attributes any additional attributes for the element (such as class
 *    or CSS styles or size
 -->
<#macro formPasswordInput path attributes="">
    <@formInput path, attributes, "password"/>
</#macro>

<#--
 * formHiddenInput
 *
 * Generate a form input field of type 'hidden' and bind it to an attribute
 * of a command or bean. This functionality can also be obtained by calling
 * the formInput macro with a 'type' parameter of 'hidden'.
 *
 * @param path the name of the field to bind to
 * @param attributes any additional attributes for the element (such as class
 *    or CSS styles or size
 -->
<#macro formHiddenInput path attributes="">
    <@formInput path, attributes, "hidden"/>
</#macro>

<#--
 * formTextarea
 *
 * Display a text area and bind it to an attribute of a command or bean.
 *
 * @param path the name of the field to bind to
 * @param attributes any additional attributes for the element (such as class
 *    or CSS styles or size
 -->
<#macro formTextarea path attributes="">
    <@bind path/>
<textarea id="${status.expression?replace('[','')?replace(']','')}" name="${status.expression}" ${attributes}>${stringStatusValue}</textarea>
</#macro>

<#--
 * formSingleSelect
 *
 * Show a selectbox (dropdown) input element allowing a single value to be chosen
 * from a list of options.
 *
 * @param path the name of the field to bind to
 * @param attributes any additional attributes for the element (such as class
 *    or CSS styles or size
 *
 * modify by Alfred
-->
<#macro formSingleSelect path attributes="">
    <@bind path/>
<select data-am-selected id="${status.expression?replace('[','')?replace(']','')}" name="${status.expression}">
    <#nested>
</select>
</#macro>

<#--
 * formRadioButtons
 *
 * Show radio buttons.
 *
 * @param path the name of the field to bind to
 * @param value a value for the radio
 * @param attributes any additional attributes for the element (such as class
 *    or CSS styles or size
 *
 * modify by Alfred
-->
<#macro formRadioButton path value attributes="">
    <@bind path/>
    <#assign id="${status.expression?replace('[','')?replace(']','')}${value}">
    <input type="radio" id="${id}" name="${status.expression}" value="${value}"<#if stringStatusValue == value> checked="checked"</#if> ${attributes}<@closeTag/>
</#macro>

<#--
 * formSingleRadioButtons
 *
 * Show radio buttons.
 *
 * @param path the name of the field to bind to
 * @param options a map (value=label) of all the available options
 * @param separator the html tag or other character list that should be used to
 *    separate each option. Typically '&nbsp;' or '<br>'
 * @param attributes any additional attributes for the element (such as class
 *    or CSS styles or size

  modify by kuanghb
-->
<#macro formSingleRadioButton path options separator attributes="">
    <@bind path/>
    <#list options?keys as value>
        <#assign id="${status.expression?replace('[','')?replace(']','')}${value_index}">
        <input type="radio" id="${id}" name="${status.expression}" value="${value?html}"<#if stringStatusValue == value> checked="checked"</#if> ${attributes}<@closeTag/>
    <label for="${id}">${options[value]?html}</label>${separator}
    </#list>
</#macro>

<#--
 * formCheckboxes
 *
 * Show checkboxes.
 *
 * @param path the name of the field to bind to
 * @param options a map (value=label) of all the available options
 * @param separator the html tag or other character list that should be used to
 *    separate each option. Typically '&nbsp;' or '<br>'
 * @param attributes any additional attributes for the element (such as class
 *    or CSS styles or size
-->
<#macro formCheckboxes path options separator attributes="">
    <@bind path/>
    <#list options?keys as value>
        <#assign id="${status.expression?replace('[','')?replace(']','')}${value_index}">
        <#assign isSelected = contains(status.actualValue?default([""]), value)>
        <input type="checkbox" id="${id}" name="${status.expression}" value="${value?html}"<#if isSelected> checked="checked"</#if> ${attributes}<@closeTag/>
    <label for="${id}">${options[value]?html}</label>${separator}
    </#list>
<input type="hidden" name="_${status.expression}" value="on"/>
</#macro>

<#--
 * formCheckbox
 *
 * Show a single checkbox.
 *
 * @param path the name of the field to bind to
 * @param attributes any additional attributes for the element (such as class
 *    or CSS styles or size
 *
 * modify by Alfred
-->
<#macro formCheckbox path attributes="">
    <@bind path />
    <#assign id="${status.expression?replace('[','')?replace(']','')}">
    <#assign isSelected = status.value?? && status.value?string=="true">
<input type="hidden" name="_${status.expression}" value="on"/>
<input type="checkbox" id="${id}" name="${status.expression}"<#if isSelected> checked="checked"</#if> ${attributes}/>
</#macro>

<#--
 * checkSelected
 *
 * Check a value in a list to see if it is the currently selected value.
 * If so, add the 'selected="selected"' text to the output.
 * Handles values of numeric and string types.
 * This function is used internally but can be accessed by user code if required.
 *
 * @param path the name of the field to bind to
 * @param value the current value in a list iteration
 *
 * modify by Alfred
-->
<#macro checkSelected path value>
    <@bind path />
    <#if stringStatusValue?is_number && stringStatusValue == value?number>selected="selected"</#if>
    <#if stringStatusValue?is_string && stringStatusValue == value?string>selected="selected"</#if>
</#macro>
<#--
 * contains
 *
 * Macro to return true if the list contains the scalar, false if not.
 * Surprisingly not a FreeMarker builtin.
 * This function is used internally but can be accessed by user code if required.
 *
 * @param list the list to search for the item
 * @param item the item to search for in the list
 * @return true if item is found in the list, false otherwise
-->
<#function contains list item>
    <#list list as nextInList>
        <#if nextInList == item><#return true></#if>
    </#list>
    <#return false>
</#function>

<#--
 * closeTag
 *
 * Simple macro to close an HTML tag that has no body with '>' or '/>',
 * depending on the value of a 'xhtmlCompliant' variable in the namespace
 * of this library.
-->
<#macro closeTag>
    <#if xhtmlCompliant?exists && xhtmlCompliant>/><#else>></#if>
</#macro>

<#--
 *自定义显示所有错误信息的标签
 调用方式:
 Contorller中定义了@Valid @ModelAttribute("user") UserVo user
 那么path就是user.*
 在页面使用<@spring.showAllErrors "user.*"/>调用此方法
-->
<#macro showErrors path returnPath>
    <#assign status = springMacroRequestContext.getBindStatus(path)>
    <#if (status.errorCodes?size gt 0)>
    <div class="am-alert am-alert-danger" data-am-alert="">
      <button type="button" class="am-close">×</button>
      <p>
          <#list status.errorMessages as error>
          ${error}<br/>
          </#list>
      </p>
    </div>
    <#else>
        <#if redirect!true>
        <div class="am-alert am-alert-success" data-am-alert="">
          <button type="button" class="am-close">×</button><p>您的信息已经提交成功！ 您可以继续添加，也可以点击 <a href="<@spring.url '${returnPath}'/>" class="color_Blue">这里</a> 返回列表</p>
        </div>
        </#if>
    </#if>
</#macro>

<#macro showError separator=" " class="" style="">
    <#assign id="${status.expression?replace('[','')?replace(']','')}Info">
<span id="${id}" class="${class}" style="${style}"<@closeTag/>
    <#list status.errorMessages as error>
    ${error}<#if error_has_next>${separator}</#if>
    </#list>
</#macro>

<#--
 * showMsg，信息显示通用标签
 *
 * 后台使用model.addAttribute("successMsg", "")、model.addAttribute("errorMsg", "")
 * 传入相关的操作成功或失败信息，前台页面以对应的样式展示给用户
 *
-->
<#macro showMsg returnPath="">
    <#if errorMsg??>
    <div class="am-alert am-alert-danger" data-am-alert=""><button type="button" class="am-close">×</button><p>${errorMsg}</p></div>
    <#else>
        <#if successMsg??>
            <#if returnPath="">
            <div class="am-alert am-alert-success" data-am-alert=""><button type="button" class="am-close">×</button><p>${successMsg}</p></div>
            <#else>
            <div class="am-alert am-alert-success" data-am-alert=""><button type="button" class="am-close">×</button><p>${successMsg}<br /> 您可以可以点击 <a href="${springMacroRequestContext.getContextUrl(returnPath)}" class="color_Blue">这里</a> 返回列表</p></div>
            </#if>
        </#if>
    </#if>
</#macro>

<#macro encryAccount value>
<#--手机号取第4到8位替换-->
    <#assign str = value?substring(3,7)>
${value?replace(str, "****")}
<#--邮箱@符前四位替换-->
</#macro>