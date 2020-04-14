/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.converter.Promoter;
import com.twilio.http.HttpMethod;
import com.twilio.twiml.GenericNode;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.util.List;

/**
 * Test class for {@link Gather}
 */
public class GatherTest {
    @Test
    public void testEmptyElement() {
        Gather elem = new Gather.Builder().build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Gather/>",
            elem.toXml()
        );
    }

    @Test
    public void testEmptyElementUrl() {
        Gather elem = new Gather.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CGather%2F%3E", elem.toUrl());
    }

    @Test
    public void testElementWithParams() {
        Gather elem = new Gather.Builder()
            .inputs(Promoter.listOfOne(Gather.Input.DTMF))
            .action(URI.create("https://example.com"))
            .method(HttpMethod.GET)
            .timeout(1)
            .speechTimeout("speech_timeout")
            .maxSpeechTime(1)
            .profanityFilter(true)
            .finishOnKey("finish_on_key")
            .numDigits(1)
            .partialResultCallback(URI.create("https://example.com"))
            .partialResultCallbackMethod(HttpMethod.GET)
            .language(Gather.Language.AF_ZA)
            .hints("hints")
            .bargeIn(true)
            .debug(true)
            .actionOnEmptyResult(true)
            .speechModel(Gather.SpeechModel.DEFAULT)
            .build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Gather action=\"https://example.com\" actionOnEmptyResult=\"true\" bargeIn=\"true\" debug=\"true\" finishOnKey=\"finish_on_key\" hints=\"hints\" input=\"dtmf\" language=\"af-ZA\" maxSpeechTime=\"1\" method=\"GET\" numDigits=\"1\" partialResultCallback=\"https://example.com\" partialResultCallbackMethod=\"GET\" profanityFilter=\"true\" speechModel=\"default\" speechTimeout=\"speech_timeout\" timeout=\"1\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithExtraAttributes() {
        Gather elem = new Gather.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Gather a=\"b\" foo=\"bar\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithChildren() {
        Gather.Builder builder = new Gather.Builder();

        builder.say(new Say.Builder("message").voice(Say.Voice.MAN).loop(1).language(Say.Language.ARB).build());

        builder.pause(new Pause.Builder().length(1).build());

        builder.play(new Play.Builder(URI.create("https://example.com")).loop(1).digits("digits").build());

        Gather elem = builder.build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Gather>" +
                "<Say language=\"arb\" loop=\"1\" voice=\"man\">message</Say>" +
                "<Pause length=\"1\"/>" +
                "<Play digits=\"digits\" loop=\"1\">https://example.com</Play>" +
            "</Gather>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithTextNode() {
        Gather.Builder builder = new Gather.Builder();

        builder.addText("Hey no tags!");

        Gather elem = builder.build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Gather>" +
            "Hey no tags!" +
            "</Gather>",
            elem.toXml()
        );
    }

    @Test
    public void testMixedContent() {
        GenericNode.Builder child = new GenericNode.Builder("Child");
        child.addText("content");

        Gather.Builder builder = new Gather.Builder();

        builder.addText("before");
        builder.addChild(child.build());
        builder.addText("after");

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Gather>" +
            "before" +
            "<Child>content</Child>" +
            "after" +
            "</Gather>",
            builder.build().toXml()
        );
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        Gather.Builder builder = new Gather.Builder();
        Gather elem = builder.addChild(node).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Gather>" +
            "<genericTag>" +
            "Some text" +
            "</genericTag>" +
            "</Gather>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithGenericNodeAttributes() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        GenericNode node = genericBuilder.option("key", "value").addText("someText").build();

        Gather.Builder builder = new Gather.Builder();
        Gather elem = builder.addChild(node).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Gather>" +
            "<genericTag key=\"value\">" +
            "someText" +
            "</genericTag>" +
            "</Gather>",
            elem.toXml()
        );
    }
}