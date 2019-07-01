package br.ufscar.dc.dsw

import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class EditoraController extends RestfulController {
    static responseFormats = ['json', 'xml']
    EditoraController() {
        super(Editora)
    }
}