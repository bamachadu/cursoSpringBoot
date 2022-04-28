Installar a extensão REST Client for Visual Studio Code(Huachao Mao)

Configurar dentro da pasta .vscode o arquivo settings.json, a seção "rest-client.environmentVariables";
  - Nela deve conter:
    "host": caminho da api que esta sendo executada
    "contentType": "application/json",
    "token": o token para acesso na segurança da aplicação

Dentro do arquivo http para testar a requisição, alterar o mesmo para chamar o enviroment da seguinte forma:
  - Ctrl+Alt+E(Cmd+Alt+E for macOS)
  - ou press F1 and then select/type Rest Client: Switch Environment.

