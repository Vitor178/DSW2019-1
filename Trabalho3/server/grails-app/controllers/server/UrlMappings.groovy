package server

class UrlMappings {

    static mappings = {
        "/livros"(resources:"livro")
        "/editoras"(resources:"editora")
        "/teatros"(resources:"teatro")
        "/sites"(resources:"site")
        "/promocoes"(resources:"promocao")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
