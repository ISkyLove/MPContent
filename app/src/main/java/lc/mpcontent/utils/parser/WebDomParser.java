package lc.mpcontent.utils.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import lc.mpcontent.bean.WebBean;
import lc.mpcontent.utils.parser.parserbean.WebsTab;

/**
 * Created by lin on 16-5-22.
 */
public class WebDomParser implements IDOMParserXML<WebBean> {

    DocumentBuilder mBuilder = null;

    public WebDomParser() throws Exception {
        mBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }


    public List<WebBean> getDataList(String filepath) {
        List<WebBean> mList = null;
        File mparserFile = new File(filepath);
        if (mparserFile.exists() && mparserFile.canRead()) {
            try {
                mList = getDataList(new FileInputStream(mparserFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return mList;
    }

    @Override
    public List<WebBean> getDataList(InputStream inputStream) {
        List<WebBean> mList = null;
        try {
            Document mwebdoc = mBuilder.parse(inputStream);
            Element root = mwebdoc.getDocumentElement();
            mList = parser(root);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mList;
    }

    private List<WebBean> parser(Element root) {
        List<WebBean> mList = new ArrayList<>();
        NodeList webs = root.getElementsByTagName(WebsTab.WEB);
        for (int i = 0; i < webs.getLength(); i++) {
            Element webElement = (Element) webs.item(i);
            WebBean webBean = new WebBean();
            NodeList webNodes = webElement.getChildNodes();
            for (int j = 0; j < webNodes.getLength(); j++) {
                if(webNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Element child = (Element) webNodes.item(j);
                    String nodename = child.getTagName();
                    String nodeValue = child.getTextContent();
                    switch (nodename) {
                        case WebsTab.ID:
                            webBean.setId(Integer.parseInt(nodeValue));
                            break;
                        case WebsTab.TITLE:
                            webBean.setTitle(nodeValue);
                            break;
                        case WebsTab.URL:
                            webBean.setUrl(nodeValue);
                            break;
                        case WebsTab.LOGO:
                            webBean.setLogo(nodeValue);
                            break;
                        case WebsTab.ICO:
                            webBean.setIco(nodeValue);
                            break;
                        case WebsTab.DEC:
                            webBean.setDescription(nodeValue);
                            break;
                    }
                }
            }
            mList.add(webBean);
        }

        return mList;
    }
}
