#include <iostream>
#include <vector>
#include <string>

using namespace std;

// ---------------------------
// Product
// ---------------------------
class Page {
public:
    virtual string getPageName() = 0;
};

// ---------------------------
// Concrete Products for Resume
// ---------------------------
class SkillsPage : public Page {
public:
    string getPageName() override {
        return "SkillsPage";
    }
};

class EducationPage : public Page {
public:
    string getPageName() override {
        return "EducationPage";
    }
};

class ExperiencePage : public Page {
public:
    string getPageName() override {
        return "ExperiencePage";
    }
};

// ---------------------------
// Concrete Products for Report
// ---------------------------
class SummaryPage : public Page {
public:
    string getPageName() override {
        return "SummaryPage";
    }
};

class IntroductionPage : public Page {
public:
    string getPageName() override {
        return "IntroductionPage";
    }
};

class ResultsPage : public Page {
public:
    string getPageName() override {
        return "ResultsPage";
    }
};

class ConclusionPage : public Page {
public:
    string getPageName() override {
        return "ConclusionPage";
    }
};

// ---------------------------
// Abstract Creator
// ---------------------------
class Document {
public:
    vector<Page*> pages;

    // Constructor calls factory method
    Document() {
        createPages();
    }

    virtual string getDocName() = 0;

    // Factory Method
    virtual void createPages() = 0;
};

// ---------------------------
// Concrete Creator - Resume
// ---------------------------
class Resume : public Document {
public:
    void createPages() override {
        pages.push_back(new SkillsPage());
        pages.push_back(new EducationPage());
        pages.push_back(new ExperiencePage());
    }

    string getDocName() override {
        return "Resume";
    }
};

// ---------------------------
// Concrete Creator - Report
// ---------------------------
class Report : public Document {
public:
    void createPages() override {
        pages.push_back(new SummaryPage());
        pages.push_back(new IntroductionPage());
        pages.push_back(new ResultsPage());
        pages.push_back(new ConclusionPage());
    }

    string getDocName() override {
        return "Report";
    }
};

// ---------------------------
// Main Application
// ---------------------------
int main() {

    vector<Document*> documents;

    documents.push_back(new Resume());
    documents.push_back(new Report());

    for (Document* document : documents) {

        cout << "\n" << document->getDocName() << " --" << endl;

        for (Page* page : document->pages) {
            cout << " " << page->getPageName() << endl;
        }
    }

    return 0;
}
