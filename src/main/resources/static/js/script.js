/* preview image*/
function previewImages() {
	var preview = document.querySelector('#preview');
	if (this.files) {
		[].forEach.call(this.files, readAndPreview);
	}
	function readAndPreview(file) {
		// Make sure `file.name` matches our extensions criteria
		if (!/\.(jpe?g|png|gif)$/i.test(file.name)) {
			return alert(file.name + " is not an image");
		}
		var reader = new FileReader();
		reader.addEventListener("load", function () {
			var image = new Image();
			image.title = file.name;
			image.height = 250;
			image.src = this.result;
			image.className += 'col-md-3'
			preview.appendChild(image);
		});
		reader.readAsDataURL(file);
	}
}
var x=document.querySelector('#file-input');
if(x !=null){
x.addEventListener("change", previewImages);
}
function deletProduct(subCatid, id) {
	swal({
		title: "Are you sure?",
		text: "you Want to delete this detail...",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {

				window.location = "/myadmin/deletProduct/" + id + "/" + subCatid
			} else {
				swal("Your detail is safe!");
			}
		});
}
function deletSubCategory(id) {
	swal({
		title: "Are you sure?",
		text: "you Want to delete this detail...",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {

				window.location = "/myadmin/deletSubCategory/" + id
			} else {
				swal("Your detail is safe!");
			}
		});
}
function deletCategory(id) {
	swal({
		title: "Are you sure?",
		text: "you Want to delete this detail...",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {

				window.location = "/myadmin/deletCategory/" + id
			} else {
				swal("Your detail is safe!");
			}
		});
}
function addtoCart(pId) {
	swal({
		title: "Are you sure?",
		text: "you Want to delete this detail...",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((addcart) => {
			if (addcart) {
				window.location = "/user/addToCart/" + pId + "/1"

			} else {
				swal("Your detail is safe!");
			}
		});
}


function addToCart(pId) {
	var quantity = document.querySelector('#pQnty').value;
	swal({
		title: "Are you sure?",
		text: "you Want to delete this detail...",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((addcart) => {
			if (addcart) {
				window.location = "/user/addToCart/" + pId + "/" + quantity

			} else {
				swal("Your detail is safe!");
			}
		});

}

function deletCart(id) {
	swal({
		title: "Are you sure?",
		text: "you Want to delete this detail...",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {

				window.location = "/user/deletecart/" + id
			} else {
				swal("Your detail is safe!");
			}
		});
}
function sortItemAtoZ() {

	window.location = "/categorywiseproduct/0/sort/AToZ"

}
function sortItemZtoA() {
	window.location = "/categorywiseproduct/0/sort/ZToA"

}
function sortItemHighToLow() {
	window.location = "/categorywiseproduct/0/sort/HToL"

}
function sortItemLowToHigh() {
	window.location = "/categorywiseproduct/0/sort/LToH"

}



