package com.limitlessaudio.furfriction.podcast.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**Adapter for CDATA handling in JAXB marshall operations.
 * @author adam_hegedus
 */
public class AdapterCDATA extends XmlAdapter<String, String> {

    @Override
    public String unmarshal(String text) throws Exception {
        return text;
    }

    @Override
    public String marshal(String text) throws Exception {
        return "<![CDATA[" + text + "]]>";
    }

}
