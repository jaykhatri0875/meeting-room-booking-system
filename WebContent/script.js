//Options for list of available members
var availableMembersOptions = {
    valueNames: ['name', 'id'],
    item: '<li class="list-group-item list-group-item-action"><strong>Name:</strong> <span class="name"></span> - <strong>ID:</strong> <span class="id"></span></li>'
}

//Values for list of available members
//Values of available members to be populated from database on loading the page

var availableMembersValues = [
    {
        name: 'Anuj Chetwani',
        id: 69
    },
    {
        name: 'Bhavesh Ittadwar',
        id: 26
    },
    {
        name: 'Yash Zambre',
        id: 22
    },
    {
        name: 'Sambhav Khajanchi',
        id: 07
    },
    {
        name: 'Kunal Kodam',
        id: 786
    },
    {
        name: 'Shardul Deolankar',
        id: 123
    },
]

//List Object for available members
var availableMemberList = new List('available-members', availableMembersOptions, availableMembersValues);

//Options for list of selected members
var selectedMembersOptions = {
    valueNames: ['name', 'id'],
    item: '<li class="list-group-item list-group-item-action"><strong>Name:</strong> <span class="name"></span> - <strong>ID:</strong> <span class="id"></span></li>'
}


//List Object for selected members
var selectedMemberList = new List('selected-members', selectedMembersOptions);

//Add Members to selected members list on click
$('#available-members').on('click', 'li', function(){
    var memberId = $(this).find('.id').text();
    var memberName = $(this).find('.name').text();
    //Add to selected members list
    selectedMemberList.add({id: memberId, name: memberName});
    availableMemberList.remove('id', memberId);
});

//Remove Members from selected members list on click
$('#selected-members .list').on('click', 'li', function(){
    var memberId = $(this).find('.id').text();
    var memberName = $(this).find('.name').text();
    //Add to selected members list
    availableMemberList.add({id: memberId, name: memberName});
    selectedMemberList.remove('id', memberId);
});

//add meber to specified list
function addMemberToList(memberId, memberName, list){
    list.add({
        id: memberId,
        name: memberName
    });
}

//Sends a hidden input as comma separated list of selected members' IDs before submitting
$("#organise-meeting").submit(function(){
    var ids = [];
    $('#selected-members .list li').each(function(index, value){
        ids.push($(this).find('.id').text());
    });
    ids = ids.join();
    $('#selected-members-input').attr('value', ids);
})