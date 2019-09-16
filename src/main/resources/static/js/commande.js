function decrementValue() {
  let value = parseInt(document.getElementById('articleQuantity').value, 10);
  value = isNaN(value) ? 0 : value;
  value--;
  value < 0 ? value++ : value;
  document.getElementById('articleQuantity').value = value;
}

function incrementValue() {
  let value = parseInt(document.getElementById('articleQuantity').value, 10);
  value = isNaN(value) ? 0 : value;
  value++;
  document.getElementById('articleQuantity').value = value;
}
