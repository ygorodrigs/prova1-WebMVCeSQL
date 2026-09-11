# Evidências de Execução (Parte A)

## Ficha do Animal
![Ficha](fichaDoAnimal.png)

## Ficha do Tutor
![Tutor](fichaDoTutor.png)

## Resumo da Clínica
![Resumo](resumoGeral.png)

## Banco de Dados (Console H2)
![Console H2](console.png)

---

# Parte B — Planejamento da camada de controle

| Ação | Tipo de requisição | URL completa | Mapeamento (anotação) | Template |
| :--- | :--- | :--- | :--- | :--- |
| Mostrar a ficha do animal | GET | http://localhost:8080/ficha_12 | @GetMapping("/ficha_12") | ficha.html |
| Mostrar a ficha do tutor | GET | http://localhost:8080/tutor_12 | @GetMapping("/tutor_12") | tutor.html |
| Mostrar o resumo da clínica | GET | http://localhost:8080/resumo_12 | @GetMapping("/resumo_12") | resumo.html |
| Cadastrar um novo animal | POST | não existe | não existe | não existe |

### B.1
O Spring utiliza a **URL** (o caminho/path da requisição) para diferenciar a execução entre os métodos `ficha()` e `resumo()`. O verbo HTTP isoladamente não bastaria porque ambas as rotas utilizam o mesmo verbo (**GET**); sem a diferenciação pelo caminho da URL, o framework não saberia qual método acionar.