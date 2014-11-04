/**The package-info is used to handle namespaces in the same xml file.
 * The "atom:" and "itunes:" prefixes are covered.
 */
@XmlSchema(xmlns = {@XmlNs(prefix = "itunes", namespaceURI = "http://www.itunes.com/dtds/podcast-1.0.dtd"),
    @XmlNs(prefix = "atom", namespaceURI = "http://www.w3.org/2005/Atom")}, elementFormDefault = XmlNsForm.QUALIFIED)
package com.limitlessaudio.furfriction.podcast.xml;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;

