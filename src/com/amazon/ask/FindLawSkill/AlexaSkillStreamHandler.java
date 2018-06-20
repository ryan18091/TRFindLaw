/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.amazon.ask.FindLawSkill;

import com.amazon.ask.FindLawSkill.handlers.*;
import com.amazon.ask.FindLawSkill.handlers.CriminalProcedure.*;
import com.amazon.ask.FindLawSkill.handlers.DUI.BUI.*;
import com.amazon.ask.FindLawSkill.handlers.DUI.DUItrafficStops.*;
import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class AlexaSkillStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new FindALawyerIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new WhatsMyZipcodeIntentHandler(),
                        new MyZipcodeIsIntentHandler(),
                        new FallBackIntentHandler(),
                        new DUItrafficStopOneIntentHandler(),
                        new DUItrafficStopTwoIntentHandler(),
                        new DUItrafficStopThreeIntentHandler(),
                        new DUItrafficStopFourIntentHandler(),
                        new DUItrafficStopFiveIntentHandler(),
                        new DUItrafficStopSixIntentHandler(),
                        new DUItrafficStopSevenIntentHandler(),
                        new DUItrafficStopEightIntentHandler(),
                        new DUItrafficStopNineIntentHandler(),
                        new DUItrafficStopTenIntentHandler(),
                        new DUItrafficStopElevenIntentHandler(),
                        new DUItrafficStopTwelveIntentHandler(),
                        new BUIOneIntentHandler(),
                        new BUITwoIntentHandler(),
                        new BUIThreeIntentHandler(),
                        new BUIFourIntentHandler(),
                        new BUIFiveIntentHandler(),
                        new BUISixIntentHandler(),
                        new BUISevenIntentHandler(),
                        new BUIEightIntentHandler(),
                        new BUINineIntentHandler(),
                        new CriminalProcedureOneHandler(),
                        new CriminalProcedureTwoHandler(),
                        new CriminalProcedureThreeHandler(),
                        new CriminalProcedureFourHandler(),
                        new CriminalProcedureFiveHandler(),
                        new CriminalProcedureSixHandler(),
                        new CriminalProcedureSevenHandler())
//                        new WhatsMyZipcodeIntentHandler())
                // Add your skill id below
                //.withSkillId("")
                .build();
    }

    public AlexaSkillStreamHandler() {
        super(getSkill());
    }

}


