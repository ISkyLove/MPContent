package lc.mpcontent.utils.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lin on 16-5-22.
 */
public abstract class BaseSAXHandler <T> extends DefaultHandler {

    protected  List<T> mData;

    protected String mTabName;
    protected Attributes mAttr;
    protected  String mTabContent;

    public interface OnParserFinishListen <T>{
        void OnParserFinishListen(List<T> datas);
    }

    protected OnParserFinishListen mFinishListen;

    public void setOnParserFinishListen(OnParserFinishListen listen){
        mFinishListen = listen;
    }

    @Override
    public void startDocument() throws SAXException {
        mData = new ArrayList<T>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        mAttr = attributes;

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        mTabName = localName;
        parserElement(mTabName,mTabContent,mAttr);
        mTabName = null;
        mTabContent = null;
        mAttr = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        mTabContent = new String(ch,start,length);
    }

    protected  abstract  void parserElement(String tabname,String tabcontent,Attributes tabattr);

    @Override
    public void endDocument() throws SAXException {
        if(mFinishListen != null){
            mFinishListen.OnParserFinishListen(mData);
        }
    }

    public List<T> getDatas(){
        return mData;
    }
}
