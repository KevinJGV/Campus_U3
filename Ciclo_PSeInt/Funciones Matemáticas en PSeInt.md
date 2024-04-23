# Funciones Matemáticas en PSeInt

## PSeInt

Las funciones en este pseudocódigo se utilizan de forma similar a otros lenguajes, se coloca su nombre seguido de los argumentos para la misma encerrados entre paréntesis.

En PSeInt las funciones matemáticas (es decir que devuelven un resultado de tipo numérico) son:

- abs (valor absoluto).
- trunc (valor truncado).
- redon (valor redondeado).
- rc (raíz cuadrada).
- sen (seno).
- cos (coseno).
- tan (tangente).
- asen (arcoseno)
- acos (arcocoseno).
- atan (arcotangente).
- ln (logaritmo natural).
- exp (exponencial).
- azar (número aleatorio).

Comenzaremos explicando los tres primeros, es decir, "abs", "trunc" y "redon". El valor absoluto de un número x se escribe como |x| y es su valor numérico sin signo, un ejemplo en PSeInt seria:

[![img](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh951Mam86bbh_mBiEB_qvNarAW5W7DOCW7pK5cvv1RKxMMogufVC0OkdplypjN2lihHlCOz-7lfLf6HNozQaV985pwHndCBmB9Lj3ZvhS1bKVWetb90Qg2arakgaG90OxCEKkhxnwwOw/s16000/x1.PNG)](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh951Mam86bbh_mBiEB_qvNarAW5W7DOCW7pK5cvv1RKxMMogufVC0OkdplypjN2lihHlCOz-7lfLf6HNozQaV985pwHndCBmB9Lj3ZvhS1bKVWetb90Qg2arakgaG90OxCEKkhxnwwOw/s486/x1.PNG)

[![img](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi7CJ_vP20O2PIHHsfk3wVMamBnDaDS5GaYkYbp5-WRhpzDLAOSorPEKD5iyCmFtOqa2DuJu3PhiGM8HvHTkuQPYlClnMKq2GhAVvGj11NEFq3Jsv0xr-VWqz4vv_xwOJdn-FZ2opUZAQ/s16000/x2.PNG) ](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi7CJ_vP20O2PIHHsfk3wVMamBnDaDS5GaYkYbp5-WRhpzDLAOSorPEKD5iyCmFtOqa2DuJu3PhiGM8HvHTkuQPYlClnMKq2GhAVvGj11NEFq3Jsv0xr-VWqz4vv_xwOJdn-FZ2opUZAQ/s333/x2.PNG)

 

Al aplicarle el valor absoluto resultaría lo siguiente: 

[![img](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEg57Efgy2nhTQVPyB7IszbytCexUl-0Z-RFDjjWBeqMy3MG4JInqnXNkmQ5jjTDkA3515boWk70WlGG456fkxNRbjFYmWbR51Z4Tm7PtIi3j41ZHoxepVarDBzlXBtOwRKD59O6fStXtg/s16000/x3.PNG)](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEg57Efgy2nhTQVPyB7IszbytCexUl-0Z-RFDjjWBeqMy3MG4JInqnXNkmQ5jjTDkA3515boWk70WlGG456fkxNRbjFYmWbR51Z4Tm7PtIi3j41ZHoxepVarDBzlXBtOwRKD59O6fStXtg/s494/x3.PNG)

[![img](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgmO6FaNFB336KiTIQk0ZV115TP2GDHZ1oQfLVvMg4OQQqtHoSz5Cw9O22fPq6IOvl90QbNC30fjI-vTIu2XTwufssko0LzKWmBgOeOlnHNbxBzNZS8tC3GDnYc5X8xT0pBfSj2MSAgqw/s16000/x4.PNG)](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgmO6FaNFB336KiTIQk0ZV115TP2GDHZ1oQfLVvMg4OQQqtHoSz5Cw9O22fPq6IOvl90QbNC30fjI-vTIu2XTwufssko0LzKWmBgOeOlnHNbxBzNZS8tC3GDnYc5X8xT0pBfSj2MSAgqw/s335/x4.PNG)

La función "trunc" elimina todos los números después del punto decimal para dejar como resultado sólo al número entero.

 

[![img](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgqIoKZW_gayu016JyCL7V1a5rIuAj_ekd2REIllASw05zxpBDiz4jBptgyuY7XHrcSNjTkUye5xW-0QlxMdDB8lROGFshv09bni7tzX0XjRKnN1EXhPuhNpilsFgY-obhU1Wtu_2PyZg/s16000/3.PNG)](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgqIoKZW_gayu016JyCL7V1a5rIuAj_ekd2REIllASw05zxpBDiz4jBptgyuY7XHrcSNjTkUye5xW-0QlxMdDB8lROGFshv09bni7tzX0XjRKnN1EXhPuhNpilsFgY-obhU1Wtu_2PyZg/s364/3.PNG)

[![img](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi-VmssChS5WVJOuYVXbiZHKnjyZWv_wmqxomUrdyqhEKSb-QloJVFPN7VrZLBmBHxCe4ww2zNSc9y0UUXbbuWV9gsoUqV8ehnzliKycioXDhhbTRSppE_9vk6pGSviIqv11tmPgm__cg/s16000/4.PNG)](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi-VmssChS5WVJOuYVXbiZHKnjyZWv_wmqxomUrdyqhEKSb-QloJVFPN7VrZLBmBHxCe4ww2zNSc9y0UUXbbuWV9gsoUqV8ehnzliKycioXDhhbTRSppE_9vk6pGSviIqv11tmPgm__cg/s345/4.PNG)

 

La función "redon" redondea los decimales para dar como resultado el número entero, los decimales >= . 5, se redondean al próximo número, por ejemplo 6.5 se redondea a 7, y 6.499 a 6.

[![img](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjXcBCjLvjUXgCbUbPa8Bl37dtdx5592k8VA85q5LKQy7GrUqRn3B29XsuoCuV9qfB5JJN9Ilr_LFQjiDQZ5NIcFcG7_bo2Kx0UX8E_vDrndzN5Xk134bCvJDQOTd3IXsUrCHxdin0z0g/s16000/5.PNG)](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjXcBCjLvjUXgCbUbPa8Bl37dtdx5592k8VA85q5LKQy7GrUqRn3B29XsuoCuV9qfB5JJN9Ilr_LFQjiDQZ5NIcFcG7_bo2Kx0UX8E_vDrndzN5Xk134bCvJDQOTd3IXsUrCHxdin0z0g/s373/5.PNG)

[![img](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjYjnb4BYQxJtlKNy8o3fdSLjY6nJWLdAyZpiBcLR2XWS9ngk_Cj5Qmvn4-gKmdCo9ILnni9l3SFFGnVOO9dmMv_q-9WzHaLre61zwmy11P_KC_tuqzE5UccIbcAVM_FfOTwpqZteHNXw/s16000/6.PNG) ](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjYjnb4BYQxJtlKNy8o3fdSLjY6nJWLdAyZpiBcLR2XWS9ngk_Cj5Qmvn4-gKmdCo9ILnni9l3SFFGnVOO9dmMv_q-9WzHaLre61zwmy11P_KC_tuqzE5UccIbcAVM_FfOTwpqZteHNXw/s335/6.PNG)

 

Algunas de las funciones trigonométricas que incorpora PSeInt son manejadas en radianes y su uso sería algo similar a esto:

 

[![img](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjhxxxvmAXWPdNePrQpsFbRl9dJ7uJD2TTnK887aQHVuM_mkmZd2A3ujmfttcXyplrWe14yFfiiILfWHEP1T0cHaGCaHEmWXAje2P1LPZYjZvP0F3lR6IKQL9aIdXwuKhzI4qcQUMVO5Q/s16000/7.PNG) ](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjhxxxvmAXWPdNePrQpsFbRl9dJ7uJD2TTnK887aQHVuM_mkmZd2A3ujmfttcXyplrWe14yFfiiILfWHEP1T0cHaGCaHEmWXAje2P1LPZYjZvP0F3lR6IKQL9aIdXwuKhzI4qcQUMVO5Q/s547/7.PNG)

 

[![img](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgjqBE1UVrOeq_HGPw8YGdMBXNTlexPzRYqKGPVXSuUi-YG3OKCQcz1N1TnLbyZh0UDJQboC1ZFs2hyphenhyphenKSYjk6kS90FSeayjga_-P0ZsI54HHTrhw-Wwd447vyf3u18XlmC1tUK07Tx_7g/s16000/8.PNG)](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgjqBE1UVrOeq_HGPw8YGdMBXNTlexPzRYqKGPVXSuUi-YG3OKCQcz1N1TnLbyZh0UDJQboC1ZFs2hyphenhyphenKSYjk6kS90FSeayjga_-P0ZsI54HHTrhw-Wwd447vyf3u18XlmC1tUK07Tx_7g/s370/8.PNG)

La función "azar" permite crear números aleatorios dentro de un rango especificado, en el siguiente ejemplo se generarán números aleatorios entre 0 y 20.

[![img](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhJucNlUw2LJE3LCUeRa9IZvxnBMp7DfWMnTpNi0I8Z7pKSFbd_Z7L-W4P0IVjsbI5FT3KDyO4CeepGG1vuAuoag2MAyIUIz37nf_CdecB1lrhr99ALS07dR8NGwxcgdEVkkO1J8h1QPg/s16000/9.PNG)](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhJucNlUw2LJE3LCUeRa9IZvxnBMp7DfWMnTpNi0I8Z7pKSFbd_Z7L-W4P0IVjsbI5FT3KDyO4CeepGG1vuAuoag2MAyIUIz37nf_CdecB1lrhr99ALS07dR8NGwxcgdEVkkO1J8h1QPg/s354/9.PNG)

[![img](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiNcBv8xMC-6B5SSyUOTJUhObSgSawJ_B8ZcYVuiEPdBoKbsKnbjkUa0CRWdN16P-qbopuqXbb9pbNKxdyh8ZYJsGzvBhVSK7MtELrucxHMyROIyxXrq3XM5FAp3xPm_OFUd2P19RXncQ/s16000/10.PNG)](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiNcBv8xMC-6B5SSyUOTJUhObSgSawJ_B8ZcYVuiEPdBoKbsKnbjkUa0CRWdN16P-qbopuqXbb9pbNKxdyh8ZYJsGzvBhVSK7MtELrucxHMyROIyxXrq3XM5FAp3xPm_OFUd2P19RXncQ/s333/10.PNG)

[![img](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEixil6d1zjRvd-2kTx-MrA2IEpo59TqpdsSymmlmzH1cc6qfgCKZPmM-_Qa5zgBD0tF_LoUFsH-kv3NBgxpoT7N-yea5hlWk43Oj4Vw6Ta1gJGE4KTwZ26D2Hh-WNWs6IQ9KEjK8GLzeQ/s16000/11.PNG)](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEixil6d1zjRvd-2kTx-MrA2IEpo59TqpdsSymmlmzH1cc6qfgCKZPmM-_Qa5zgBD0tF_LoUFsH-kv3NBgxpoT7N-yea5hlWk43Oj4Vw6Ta1gJGE4KTwZ26D2Hh-WNWs6IQ9KEjK8GLzeQ/s334/11.PNG)