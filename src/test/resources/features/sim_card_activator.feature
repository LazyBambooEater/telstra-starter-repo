Feature: Sim Activation Successful

    Scenario: Successfully activate a sim card
        Given the sim with the following details: "1255789453849037777" and "test@gmail.com"
        Then the response should indicate active

    Scenario: Unsuccessfully activate a sim card
        Given the sim with the following details: "8944500102198304826" and "tester@gmail.com"
        Then the response should indicate inactive
    