//Sidebar

/* Set the width of the sidebar to 300px and the left margin of the page content to 3000px */
function openNav() {
    document.getElementById("mySidebar").style.width = "300px";
    document.querySelectorAll('.sidebar a').forEach((listItem) => {
        listItem.style.display = "none";
    })
    setTimeout(()=>{
        document.querySelectorAll('.sidebar a').forEach((listItem) => {
            listItem.style.display = "block";
        })
    }, 350)
  }
  
  /* Set the width of the sidebar to 0 and the left margin of the page content to 0 */
  function closeNav() {
    document.getElementById("mySidebar").style.width = "0";
    document.querySelectorAll('.sidebar a').forEach((listItem) => {
        listItem.style.display = "none";
    })
  }
