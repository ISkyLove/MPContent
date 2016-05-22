package lc.mpcontent.utils.parser;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by lin on 16-5-22.
 */
public  class BaseSAXParser implements ISAXParserXML{

    protected XMLReader mXMLReader;

    protected BaseSAXHandler mSaxHandler;

    public BaseSAXParser(BaseSAXHandler baseSAXHandler) {

        try {
            SAXParserFactory mFactory = SAXParserFactory.newInstance();
            SAXParser mParser = mFactory.newSAXParser();
            mXMLReader = mParser.getXMLReader();
            mSaxHandler = baseSAXHandler;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void parser(InputStream inputStream, BaseSAXHandler.OnParserFinishListen listen) {
        try {
            mXMLReader.setContentHandler(mSaxHandler);
            mSaxHandler.setOnParserFinishListen(listen);
            InputSource source = new InputSource(inputStream);
            mXMLReader.parse(source);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
