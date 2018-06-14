/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.amazon.ask.FindLawSkill.handlers;

import com.amazon.ask.FindLawSkill.Template3;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.Image;
import com.amazon.ask.model.interfaces.display.Template;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        String title = "Find Law";
        String primaryText = "Primary Text";
        String secondaryText = "";
        String speechText = "Welcome to Find Law, I can help you find legal advice near you. <break time=\".5s\"/> " +
                "Please say, get legal help.";
        String imageUrl = "https://www.findlawimages.com/latl/findlaw.png";

        Template3 template3 = new Template3();

        Image image = template3.getImage(imageUrl);

        Template template = template3.getBodyTemplate3(title, primaryText, secondaryText, image);


        return input.getResponseBuilder()
                .withSpeech(speechText)
//                .withSimpleCard("Find Law", speechText)
//                .addRenderTemplateDirective(template)
                .withReprompt(speechText)
                .build();
    }

//    /**
//     * Helper method to create a body template 3
//     * @param title the title to be displayed on the template
//     * @param primaryText the primary text to be displayed on the template
//     * @param secondaryText the secondary text to be displayed on the template
//     * @param image  the url of the image
//     * @return Template3
//     */
//    private Template getBodyTemplate3(String title, String primaryText, String secondaryText, Image image) {
//        return BodyTemplate3.builder()
//                .withImage(image)
//                .withTitle(title)
//                .withTextContent(getTextContent(primaryText, secondaryText))
//                .build();
//    }
//
//    /**
//     * Helper method to create the image object for display interfaces
//     * @param imageUrl the url of the image
//     * @return Image that is used in a body template
//     */
//    private Image getImage(String imageUrl) {
//        List<ImageInstance> instances = getImageInstance(imageUrl);
//        return Image.builder()
//                .withSources(instances)
//                .build();
//    }
//
//    /**
//     * Helper method to create List of image instances
//     * @param imageUrl the url of the image
//     * @return instances that is used in the image object
//     */
//    private List<ImageInstance> getImageInstance(String imageUrl) {
//        List<ImageInstance> instances = new ArrayList<>();
//        ImageInstance instance = ImageInstance.builder()
//                .withUrl(imageUrl)
//                .build();
//        instances.add(instance);
//        return instances;
//    }
//
//    /**
//     * Helper method that returns text content to be used in the body template.
//     * @param primaryText
//     * @param secondaryText
//     * @return RichText that will be rendered with the body template
//     */
//    private TextContent getTextContent(String primaryText, String secondaryText) {
//        return TextContent.builder()
//                .withPrimaryText(makeRichText(primaryText))
//                .withSecondaryText(makeRichText(secondaryText))
//                .build();
//    }
//
//    /**
//     * Helper method that returns the rich text that can be set as the text content for a body template.
//     * @param text The string that needs to be set as the text content for the body template.
//     * @return RichText that will be rendered with the body template
//     */
//    private RichText makeRichText(String text) {
//        return RichText.builder()
//                .withText(text)
//                .build();
//    }

}
