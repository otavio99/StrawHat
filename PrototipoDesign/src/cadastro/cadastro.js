
/*
 * Essa parte é um comando jquery onde se captura o evento submit do formulario.
 * A captura dos dados do formulario se da pela funcao getFormDataAsObject que
 * captura os dados do formulario e os converte para objeto. Essa função esta
 * implementada em src/utils/util.js e ela recebe como parametro o contexto (this)
 * do evento. O cadastro dos dados ocorre plea chamada da função cadastrarAssociado
 * que recebe como parametro um objeto.
 */
$('#cadastroAssociado').submit(function(e) {

    e.preventDefault()
    var obj = getFormDataAsObject(this)
    cadastrarAssociado(obj)

});

/*
 * Função que cadastra um associado e recebe como parametro um objeto contendo os dados
 * dos mesmos.
 */
function cadastrarAssociado(obj){
	//axios é um biblioteca que realiza chamadas sincronas e assincronas.
	//Link( https://github.com/axios/axios).
	axios(
    {
      url: "http://localhost:8080/associados",
      method: 'post',
      headers: {
        'Content-Type': 'application/json'
      },
      data: obj
    }
  )
	.then(function (response) {
		console.log(response)
    if(response.status == 201){
      $('div.status').addClass("alert alert-success alert-dismissible fade show");
      $('.status').html("Associado(a) "+ obj.nome+ " cadastrado com sucesso")
    }
	})
	.catch(function (error) {
		console.log(error)
	})
	.then(function () {
		// always executed
	})
}
