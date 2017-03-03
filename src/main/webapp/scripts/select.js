$(document).ready(function () {

    let allSelectors = new Set();
    allSelectors.add("#selected-1");
    allSelectors.add("#selected-2");
    allSelectors.add("#selected-3");
    allSelectors.add("#selected-4");

    let previousSelectedMap = new Map();

    for (let selector of allSelectors) {
        $(selector).change(function () {
            iterateThroughAllAndRemoveSelected(selector);
        })
    }

    function iterateThroughAllAndRemoveSelected(inputThatWasChanged) {
        let previousSelection = previousSelectedMap.get(inputThatWasChanged);
        if (previousSelection != undefined) {
            for (let selector of allSelectors) {
                $(selector).append($("<option></option>").text(previousSelection));
            }
        }

        let selectedPlayer = getSelectedPlayer(inputThatWasChanged);
        previousSelectedMap[inputThatWasChanged] = selectedPlayer;
        for (let selector of allSelectors) {
            if(selector == inputThatWasChanged){
                continue;
            }
            $(selector + " option:contains(\'" + selectedPlayer +"\')").remove();
        }
    }

    function getSelectedPlayer(id) {
        return $(id).find(':selected').text()
    }
});
