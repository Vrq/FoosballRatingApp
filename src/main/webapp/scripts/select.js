
$(document).ready(function () {

    let allSelectors = new Set();
    allSelectors.add("#player1");
    allSelectors.add("#player2");
    allSelectors.add("#player3");
    allSelectors.add("#player4");

    let previousSelectedMap = new Map();

    for (let selector of allSelectors) {
        $(selector).change(function () {
            iterateThroughAllAndRemoveSelected(selector)
        })
    }

    function iterateThroughAllAndRemoveSelected(inputThatWasChanged) {
        console.log("inputThatWasChanged= " + inputThatWasChanged);
        let previousSelection = previousSelectedMap[inputThatWasChanged];
        console.log("previousSelection " + previousSelection);
        if (previousSelection != undefined) {
            for (let selector of allSelectors) {
                if(getOptionContainingFromSelector(selector, previousSelection).length <= 0){
                    addOptionToSelector(selector, previousSelection);
                }
            }
        }

        let selectedPlayer = getSelectedPlayer(inputThatWasChanged);
        previousSelectedMap[inputThatWasChanged] = selectedPlayer;
        for (let selector of allSelectors) {
            if (selector == inputThatWasChanged) {
                continue;
            }
            getOptionContainingFromSelector(selector, selectedPlayer).remove();
        }
    }

    function addOptionToSelector(selector, text) {
        $(selector).append($("<option></option>").text(text));
    }

    function getOptionContainingFromSelector(selector, text){
        return $(selector + " option:contains(\'" + text + "\')")
    }

    function getSelectedPlayer(id) {
        return $(id).find(':selected').text()
    }
});
