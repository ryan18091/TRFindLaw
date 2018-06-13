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

import com.amazon.ask.FindLawSkill.Lawyer;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;

import java.util.List;
import java.util.Optional;

import static com.amazon.ask.FindLawSkill.handlers.WhatsMyZipcodeIntentHandler.COLOR_KEY;
import static com.amazon.ask.request.Predicates.intentName;

public class FindALawyerIntentHandler implements RequestHandler {



    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("FindALawyer"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        String speechText;
        String zipcode = (String) input.getAttributesManager().getSessionAttributes().get(COLOR_KEY);


        if (zipcode != null && !zipcode.isEmpty()){

            int intZip = Integer.parseInt(zipcode);

            Lawyer lawyer = new Lawyer();

            List<Lawyer> lawyerList = lawyer.csvToLawyerList();
            Lawyer nearestLawyer = new Lawyer();
            int nearestLawyerDistance = 2000;


            for(Lawyer l : lawyerList) {
                int distanceToLawyer = Math.abs(intZip - Integer.parseInt(l.getZip()));
                if(distanceToLawyer <= nearestLawyerDistance) {
                    nearestLawyerDistance = distanceToLawyer;
                    nearestLawyer = l;
                }
            }


//            speechText = String.format("You are all set to find a lawyer in %s.", nearestLawyer.toString());
            speechText = String.format("I recommend %s, <break time=\".5s\"/> with the firm %s.<break time=\".5s\"/>  They are located in %s.",
                    nearestLawyer.getFirst_name() + ' ' + nearestLawyer.getLast_name(), nearestLawyer.getFirm_name(),
                    nearestLawyer.getCity() + ' ' + nearestLawyer.getState());


        } else {
            speechText = "I can sure help you with that. To find the legal help near you, I will need the zipcode" +
                    " where you want to receive legal help. Start by  saying  <break time=\".5s\"/> my zipcode is <break time=\".5s\"/>" +
                    " followed by your zipcode.";
        }

        ResponseBuilder responseBuilder = input.getResponseBuilder();

        responseBuilder.withSpeech(speechText)
                .withShouldEndSession(false);

        return responseBuilder.build();
    }

}

