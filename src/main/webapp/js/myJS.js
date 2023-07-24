var educationListSize = 0;
var workExperienceLastSize = 0;
function addEducationExperience()
{
    educationListSize++;
    document.getElementById("educationExperience").insertAdjacentHTML("afterend"," <div class=\"row p-2\">\n" +
        "              <div class=\"col-sm-7 text-start\">\n" +
        "                <label class=\"col-form-label\">School "+educationListSize+":</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"school"+educationListSize+"\" id=\"school"+educationListSize+"\">\n" +
        "              </div>\n" +
        "              <div class=\"col-sm-5 text-start\">\n" +
        "                <label class=\"col-form-label\">Degree "+educationListSize+":</label>\n" +
        "                <select class=\"form-control\" name=\"degree"+educationListSize+"\" id=\"degree"+educationListSize+"\">\n" +
        "                  <option>--</option>\n" +
        "                  <option>Primary School</option>\n" +
        "                  <option>Junior High School</option>\n" +
        "                  <option>High School</option>\n" +
        "                  <option>Bachelor</option>\n" +
        "                  <option>Master</option>\n" +
        "                  <option>PHD/Doctor</option>\n" +
        "                </select>\n" +
        "              </div>\n" +
        "            </div>\n" +
        "            <div class=\"row p-2\">\n" +
        "              <div class=\"col-sm-2 text-start\">\n" +
        "                <label class=\"col-form-label\">Major:</label>\n" +
        "              </div>\n" +
        "              <div class=\"col-sm-9\">\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"major"+educationListSize+"\" id=\"major"+educationListSize+"\">\n" +
        "              </div>\n" +
        "            </div>\n" +
        "            <div class=\"row p-2\">\n" +
        "              <div class=\"col-sm-2 text-start\">\n" +
        "                <label class=\"col-form-label\">From:</label>\n" +
        "              </div>\n" +
        "              <div class=\"col-sm-4\">\n" +
        "                <input type=\"date\" class=\"form-control\" name=\"startDate"+educationListSize+"\" id=\"startDate"+educationListSize+"\" required>\n" +
        "              </div>\n" +
        "              <div class=\"col-sm-1 text-start\">\n" +
        "                <label class=\"col-form-label\">To:</label>\n" +
        "              </div>\n" +
        "              <div class=\"col-sm-4\">\n" +
        "                <input type=\"date\" class=\"form-control\" name=\"endDate"+educationListSize+"\" id=\"endDate"+educationListSize+"\" required>\n" +
        "              </div>\n" +
        "            </div>");
}
function addWorkExperience()
{
    workExperienceLastSize++;
    document.getElementById("workExperienceList").insertAdjacentHTML("afterend",
        "<div class=\"row p-2\">\n" +
        "              <div class=\"col-sm-7 text-start\">\n" +
        "                <label class=\"col-form-label\">Company "+workExperienceLastSize+":</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"company"+workExperienceLastSize+"\" id=\"company"+workExperienceLastSize+"\" required>\n" +
        "              </div>\n" +
        "              <div class=\"col-sm-5 text-start\">\n" +
        "                <label class=\"col-form-label\">Contact: </label>\n" +
        "                <input type= \"text\" class=\"form-control\" name=\"ContactInfo"+workExperienceLastSize+"\" id=\"ContactInfo"+workExperienceLastSize+"\" placeholder=\"Email/Phone\">\n" +
        "              </div>\n" +
        "            </div>\n" +
        "            <div class=\"row p-2\">\n" +
        "              <div class=\"col-sm-2 text-start\">\n" +
        "                <label class=\"col-form-label\">From:</label>\n" +
        "              </div>\n" +
        "              <div class=\"col-sm-4\">\n" +
        "                <input type=\"date\" class=\"form-control\" name=\"startDate"+workExperienceLastSize+"\" id=\"startDate"+workExperienceLastSize+"\" required>\n" +
        "              </div>\n" +
        "              <div class=\"col-sm-1 text-start\">\n" +
        "                <label class=\"col-form-label\">To:</label>\n" +
        "              </div>\n" +
        "              <div class=\"col-sm-4\">\n" +
        "                <input type=\"date\" class=\"form-control\" name=\"endDate"+workExperienceLastSize+"\" id=\"endDate"+workExperienceLastSize+"\" required>\n" +
        "              </div>\n" +
        "              <div class=\"row p-2\">\n" +
        "                <div class=\"col-sm-12 text-start\">\n" +
        "                  <label class=\"col-form-label\">Description:</label>\n" +
        "                  <textarea type=\"text\" class=\"form-control\" name=\"description"+workExperienceLastSize+"\" id=\"description"+workExperienceLastSize+"\"></textarea>\n" +
        "                </div>\n" +
        "              </div>\n" +
        "            </div>");
}








function onChange() {
    const password = document.querySelector('input[name=password]');
    const confirm = document.querySelector('input[name=confirm]');
    if (confirm.value === password.value) {
        confirm.setCustomValidity('');
    } else {
        confirm.setCustomValidity('Passwords do not match');
    }
}
