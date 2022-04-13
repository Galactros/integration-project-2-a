package com.jamal.integration.project.a;

import com.jamal.integration.project.a.service.QuestionarioService;

public class Main {

    public static void main(String[] args) {

        QuestionarioService questionarioService = new QuestionarioService();

        questionarioService.questionarioActions();
    }
}
