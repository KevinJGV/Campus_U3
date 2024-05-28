import funciones_auxiliares

db = funciones_auxiliares.opener_db()
catalogo = funciones_auxiliares.opener_catalogo()
funciones_auxiliares.menu_principal(catalogo[1],db)
catalogo[0].close()