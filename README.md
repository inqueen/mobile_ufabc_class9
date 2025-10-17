# Desenvolvimento de Aplicativos Móveis Acessíveis voltados ao Design Universal | UFABC 2025
## ATIVIDADE 9
<br>
<br>
<div align="center">
  <video src="https://github.com/user-attachments/assets/52c4c3dd-1110-4e32-a10c-b855bc3d922d" controls></video>
</div>
<br>
<br>
<b>Sobre a atividade</b> 

Usar o mesmo aplicativo do contador, feito na aula 3,  mas agora com duas ```Activities```.

```Activity 1```
Exibe o botão ```Contar``` (que incrementa o contador).
Possui também o botão ```Ir para a Página 2```, que abre a segunda ```Activity```.

```Activity 2```
Mostra o valor atual da contagem (recebido da primeira ```Activity```).
Tem um botão ```Voltar para a Página 1```, que retorna para a primeira ```Activity```.

<b>Pesquisas e Melhorias</b>

Além das aulas desse módulo, realizei pesquisas para ampliar meus conhecimentos neste contexto e 
melhorar a experiência de uso deste aplicativo: 

<i><b>MainActivity</b></i>
1. ```companion object```
   * para utilizar constantes e transportar valores entre as ```activities```:  
   ```count``` -> armazena as interações no botão principal realizadas pelo usuário 
   ```reset``` -> armazena o ```true``` do botão de retorno à ```main```

2. Supressão do ```countTextView```
   * descontinuei o uso desse inicializador de componente por estar utilizando a constante 
   ```USER_COUNT```

3. ```registerForActivityResult```
   * utilizei essa função para habilitar o ```reset```

<i><b>ResultActivity</b></i>
1. ```Intent()```
   * utilizei o ```getIntExtra``` junto com a constante ```USER_COUNT``` para obter o valor à 
   ```ResultActivity```

2. ```setCountResetResult```
   * criei esta função para enviar a ```RESET_FLAG``` com valor ```true``` quando o usuário clicar 
   no botão ```< go back```
   
<i><b>res</b></i>
1. ```res/color/button_background_primary_color.xml``` e ```res/color/button_background_primary_color.xml```
   * ```selector``` específicos para o botão principal da ```MainActivity``` e dos botões de ir e 
   voltar presentes na ```MainActivity``` e no ```ResultActivity```

<i><b>Melhorias</b></i>
1. em ```MainActivity``` entender como suprimir o ```userCountView``` que está camuflado e é utilizado
apenas para o ```countTextView```
