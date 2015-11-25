/**
 *  test app
 *
 *  Copyright 2015 Stephen Hepner
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "OnOff",
    namespace: "shepner",
    author: "Stephen Hepner",
    description: "Turn things on or off",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
  section("Title") {
    section("Turn on when motion detected:") {
      input "motion1", "capability.motionSensor", required: true, title: "Where?"
    }
    section("turn on this switch") {
      input "switch1", "capability.switch", required: true
		}
	}
}

def installed() {
  subscribe(motion1, "motion.active", motionDetectedHandler)
  subscribe(switch1, "switch.on", switchOnHandler)
  subscribe(switch1, "switch.off", switchOffHandler)

  log.debug "Installed with settings: ${settings}"
	initialize()
}

def updated() {
  log.debug "Updated with settings: ${settings}"

  unsubscribe()
  initialize()
}

def initialize() {
	// TODO: subscribe to attributes, devices, locations, etc.
}


// Event handlers /////////////////////////////////////////////////////////////////////////////

def motionDetectedHandler(evt) {
    log.debug "motionDetectedHandler called: $evt"
}

def switchOnHandler(evt) {
    log.debug "switchOnHandler called: $evt"
}

def switchOffHandler(evt) {
    log.debug "switchOffHandler called: $evt"
}



